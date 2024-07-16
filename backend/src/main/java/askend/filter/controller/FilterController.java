package askend.filter.controller;

import askend.filter.dto.FilterDto;
import askend.filter.service.FilterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/filter")
@RequiredArgsConstructor
public class FilterController {

    private final FilterService filterService;

    @PostMapping("/save")
    public FilterDto saveUserInfo(@RequestBody @Valid FilterDto dto) {
        return null; //filterService.saveUserInfo(dto);
    }

    @GetMapping("/search")
    public FilterDto getUserInfo() {
        return null; //filterService.getUserInfo();
    }
}
