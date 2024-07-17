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

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/filter")
@RequiredArgsConstructor
public class FilterController {

    private final FilterService filterService;

    @PostMapping("/save")
    public FilterDto saveUserInfo(@RequestBody @Valid FilterDto dto) {
        return filterService.saveFilter(dto);
    }

    @GetMapping("/filters")
    public List<FilterDto> getFilters() {
        return filterService.getAllFilters();
    }
}
