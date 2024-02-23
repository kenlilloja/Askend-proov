import { Component, OnInit } from '@angular/core';
import { UserService } from './user.service';
import {KasutajaInfoDto, KasutajaSektorDto} from './dto/Dto';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatTreeNestedDataSource } from "@angular/material/tree";
import { NestedTreeControl } from "@angular/cdk/tree";

@Component({
    selector: 'app-main',
    templateUrl: './main.component.html',
    styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
    user: KasutajaInfoDto = new KasutajaInfoDto();
    valdationErrors: any[] = [];
    public treeControl = new NestedTreeControl<any>(
        (node) => node.children
    );
    public dataSource = new MatTreeNestedDataSource<any>();
    public searchString = '';
    public showOnlySelected = false;

    constructor(
        private service: UserService,
        private snackBarNotification: MatSnackBar
    ) { }

    async ngOnInit(): Promise<void> {
        await this.loadKlassifikaatorid('INDUSTRY');
        await this.loadUserData();

        this.selectNodesBasedOnUserData(this.user.sektorid, this.dataSource.data);
    }

    salvestaValjad(): void {
        let selectedKlassifikaatorid = this.dataSource.data.reduce(
            (acc: any[], node: any) =>
                acc.concat(this.treeControl
                    .getDescendants(node)
                    .filter(
                        (node) => (node.children == null || node.children.length === 0) &&
                            node.selected && !this.hideLeafNode(node)
                    )
                ),
            [] as any[]
        );
        this.user.sektorid = [];
        selectedKlassifikaatorid.forEach((node: any) => {
            node.parent = null;
            this.user.sektorid.push(new KasutajaSektorDto(node.oldId, node, node.createdAt, node.lastModifiedAt));
        })

        this.service.saveUserInfo(this.user).subscribe(
            (response: any) => {
                if (response) {
                    this.snackBarNotification.open('Andmete salvestamine õnnestus!', 'Sulge', {
                        duration: 2000,
                        verticalPosition: 'top',
                        horizontalPosition: 'right'
                    });
                    this.ngOnInit();
                    this.valdationErrors = [];
                }
            },
            (error) => {
                console.error(error);
                this.valdationErrors = error.error.errors;
            }
        );
    }

    private async loadKlassifikaatorid(domainCode: string): Promise<void> {
        try {
            const data: any = await this.service.loadKlassifikaator(domainCode).toPromise();
            this.dataSource.data = data;
            Object.keys(this.dataSource.data).forEach((key: any) => {
                this.setParent(this.dataSource.data[key], null);
            });
        } catch (error) {
            console.error('Error loading categories:', error);
            throw error;
        }
    }

    private async loadUserData(): Promise<void> {
        try {
            const userData: any = await this.service.getUserData().toPromise();
            if (userData) {
                this.user = userData;
            } else {
                this.service.createNewUser().subscribe(
                    (user: any) => {
                        this.user = user;
                    },
                    (error: any) => {
                        console.error('Error creating new user:', error);
                    }
                );
            }
        } catch (error) {
            console.error('Error loading user data:', error);
            throw error;
        }
    }

    private selectNodesBasedOnUserData(userData: any[], nodes: any[]): void {
        nodes.forEach(node => {
            if (userData.some(data => data.sektor.kood === node.kood)) {
                userData.forEach(data => {
                    if (data.sektor.kood === node.kood) {
                        node.oldId = data.id;
                        node.createdAt = data.createdAt;
                        node.lastModifiedAt = data.lastModifiedAt;
                    }
                });
                this.itemToggle(true, node);
            }
            if (node.children && node.children.length > 0) {
                this.selectNodesBasedOnUserData(userData, node.children);
            }
        });
    }

    public hasChild(_: number, node: any): boolean {
        return !!node.children && node.children.length > 0;
    }

    private setParent(node: any, parent: any): void {
        node.parent = parent;
        if (node.children) {
            node.children.forEach((childNode: any) => {
                this.setParent(childNode, node);
            });
        }
    }

    private checkAllParents(node: any): void {
        if (node.parent) {
            const descendants = this.treeControl.getDescendants(node.parent);
            node.parent.selected = descendants.every((child: any) => child.selected);
            node.parent.indeterminate = descendants.some((child: any) => child.selected);
            this.checkAllParents(node.parent);
        }
    }

    public itemToggle(checked: boolean, node: any): void {
        node.selected = checked;
        if (node.children) {
            node.children.forEach((child: any) => {
                this.itemToggle(checked, child);
            });
        }
        this.checkAllParents(node);
    }

    public hideLeafNode(node: any): boolean {
        return this.showOnlySelected && !node.selected
            ? true
            : !new RegExp(this.searchString, 'i').test(node.name);
    }

    public hideParentNode(node: any): boolean {
        return this.treeControl
            .getDescendants(node)
            .filter((node: any) => node.children == null || node.children.length === 0)
            .every((node: any) => this.hideLeafNode(node));
    }
}
