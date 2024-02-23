import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from "./footer/footer.component";
import { HeaderComponent } from "./header/header.component";
import { HttpClientModule } from "@angular/common/http";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { MainComponent } from "./main/main.component";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import {
  CdkNestedTreeNode,
  CdkTree,
  CdkTreeNode,
  CdkTreeNodeDef,
  CdkTreeNodeOutlet,
  CdkTreeNodeToggle
} from "@angular/cdk/tree";
import {MatIcon} from "@angular/material/icon";
import {MatIconButton} from "@angular/material/button";
import {MatSelect, MatSelectTrigger} from "@angular/material/select";
import {MatCheckbox} from "@angular/material/checkbox";
import {
    MatNestedTreeNode,
    MatTree,
    MatTreeNode,
    MatTreeNodeDef,
    MatTreeNodeOutlet,
    MatTreeNodeToggle
} from "@angular/material/tree";
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    MainComponent,
    HeaderComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        FormsModule,
        ReactiveFormsModule,
        BrowserAnimationsModule,
        CdkTreeNode,
        CdkNestedTreeNode,
        MatIcon,
        CdkTree,
        CdkTreeNodeDef,
        MatIconButton,
        CdkTreeNodeToggle,
        CdkTreeNodeOutlet,
        MatSelectTrigger,
        MatSelect,
        MatCheckbox,
        MatTree,
        MatTreeNode,
        MatTreeNodeToggle,
        MatNestedTreeNode,
        MatTreeNodeDef,
        MatTreeNodeOutlet,
    ],
  providers: [
    provideAnimationsAsync()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
