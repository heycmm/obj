package cc.orcl.obj.controller;

import cc.orcl.obj.model.MovieVo;
import cc.orcl.obj.model.PagedResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cc.orcl.obj.service.MovieService;

/**
 *
 */
@RestController
@RequestMapping("/movie")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }


    @GetMapping
    public PagedResult<MovieVo> findByPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                           @RequestParam(defaultValue = "10") Integer pageSize,
                                           @RequestParam(required = false) Integer objType,
                                           @RequestParam(required = false) Integer keyType,
                                           @RequestParam(required = false) String keyword
    ) {
        return movieService.findByPage(pageNum, pageSize, keyType, keyword,objType);
    }

}
