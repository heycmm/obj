package cc.orcl.obj.service.impl;

import cc.orcl.obj.mapper.MovieMapper;
import cc.orcl.obj.model.MovieDocument;
import cc.orcl.obj.model.MovieVo;
import cc.orcl.obj.model.PagedResult;
import org.dromara.easyes.core.biz.EsPageInfo;
import org.dromara.easyes.core.conditions.select.LambdaEsQueryWrapper;
import org.springframework.stereotype.Service;
import cc.orcl.obj.service.MovieService;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class MovieServiceImpl implements MovieService {
    private final MovieMapper documentMapper;

    public MovieServiceImpl(MovieMapper documentMapper) {
        this.documentMapper = documentMapper;
    }


    @Override
    public PagedResult<MovieVo> findByPage(Integer pageNum, Integer pageSize, Integer keyType, String keyword, Integer objType) {
        LambdaEsQueryWrapper<MovieDocument> wrapper = new LambdaEsQueryWrapper<>();
        if (objType != null) {
            wrapper.eq(MovieDocument::getObjType, objType);
        }
        if (keyword != null && !keyword.isEmpty()) {
            keyword = keyword.trim();
            String finalKeyword = keyword;
            wrapper.and(w -> w.matchPhrase(MovieDocument::getDescription, finalKeyword)
                    .or().matchPhrase(MovieDocument::getName, finalKeyword)
                    .or().matchPhrase(MovieDocument::getTags, finalKeyword)
            );

        }
        wrapper.orderByDesc(MovieDocument::getCreateTime);
        EsPageInfo<MovieDocument> documentPageInfo = documentMapper.pageQuery(wrapper, pageNum + 1, pageSize);
        List<MovieVo> movieVoList = documentPageInfo.getList().stream().map(movie -> {
            MovieVo movieVo = new MovieVo();
            movieVo.setLink(movie.getLink());
            movieVo.setSize(movie.getSize());
            movieVo.setCreateTime(movie.getCreateTime());
            movieVo.setDescription(movie.getHighlightDescription() != null ? movie.getHighlightDescription() : movie.getDescription());
            movieVo.setPhoto(movie.getPhoto());
            movieVo.setThumbPhoto(movie.getThumbPhoto());
            movieVo.setName(movie.getHighlightName() != null ? movie.getHighlightName() : movie.getName());
            movieVo.setTags(movie.getHighlightTags() != null ? movie.getHighlightTags() : movie.getTags());
            return movieVo;
        }).collect(Collectors.toList());
        PagedResult<MovieVo> pagedResult = new PagedResult<>();
        pagedResult.setRecords(movieVoList);
        pagedResult.setCurrent(pageNum + 1);
        pagedResult.setSize(pageSize);
        pagedResult.setTotal(documentPageInfo.getTotal());
        pagedResult.setPages(documentPageInfo.getPages()); // Total pages calculation

        return pagedResult;
    }

}