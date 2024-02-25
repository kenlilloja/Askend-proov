package helmes.user.controller;

import helmes.user.dto.KasutajaInfoDto;
import helmes.user.service.KasutajaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/user")
@RequiredArgsConstructor
public class KasutajaController {

    private final KasutajaService kasutajaService;

    @PostMapping("/save")
    public KasutajaInfoDto saveUserInfo(@RequestBody @Valid KasutajaInfoDto dto) {
        return kasutajaService.saveUserInfo(dto);
    }

    @GetMapping("/search")
    public KasutajaInfoDto getUserInfo() {
        return kasutajaService.getUserInfo();
    }
}
