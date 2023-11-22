package indorm1992.testcontainers.web.mapper;

import indorm1992.testcontainers.model.Post;
import indorm1992.testcontainers.web.dto.PostDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper extends Mappable<Post, PostDto> {
}
