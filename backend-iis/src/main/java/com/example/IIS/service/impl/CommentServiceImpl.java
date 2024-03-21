package com.example.IIS.service.impl;
import com.example.IIS.domain.Comment;
import com.example.IIS.domain.Post;
import com.example.IIS.dto.CommentDto;
import com.example.IIS.dto.PostDto;
import com.example.IIS.exception.IISException;
import com.example.IIS.repository.CommentRepository;
import com.example.IIS.repository.PostRepository;
import com.example.IIS.service.CommentService;
import com.example.IIS.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostService postService;

    @Autowired
    private ModelMapper mapper;


    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {

        Comment comment = mapToEntity(commentDto);

        // retrieve post entity by id
        PostDto postDTO = postService.getPostById(postId);
        Post post = mapper.map(postDTO, Post.class);

        comment.setPost(post);

        // comment entity to DB
        Comment newComment =  commentRepository.save(comment);

        return mapToDTO(newComment);
    }

    @Override
    public List<CommentDto> getCommentsByPostId(long postId) {
        // retrieve comments by postId
        List<Comment> comments = commentRepository.findByPostId(postId);

        // convert list of comment entities to list of comment dto's
        return comments.stream().map(comment -> mapToDTO(comment)).collect(Collectors.toList());
    }

    @Override
    public CommentDto getCommentById(Long postId, Long commentId) {
        // retrieve post entity by id
        PostDto postDTO = postService.getPostById(postId);
        Post post = mapper.map(postDTO, Post.class);

        // retrieve comment by id
        Comment comment = commentRepository.findById(commentId).get();

        if(!comment.getPost().getId().equals(post.getId())){
            throw new IISException(HttpStatus.BAD_REQUEST, "Comment does not belong to post");
        }

        return mapToDTO(comment);
    }

    @Override
    public CommentDto updateComment(Long postId, long commentId, CommentDto commentRequest) {
        // retrieve post entity by id
        PostDto postDTO = postService.getPostById(postId);
        Post post = mapper.map(postDTO, Post.class);
        // retrieve comment by id
        Comment comment = commentRepository.findById(commentId).get();
        if(!comment.getPost().getId().equals(post.getId())){
            throw new IISException(HttpStatus.BAD_REQUEST, "Comment does not belongs to post");
        }

        comment.setName(commentRequest.getName());
        comment.setEmail(commentRequest.getEmail());
        comment.setBody(commentRequest.getBody());

        Comment updatedComment = commentRepository.save(comment);
        return mapToDTO(updatedComment);
    }

    @Override
    public void deleteComment(Long postId, Long commentId) {
        // retrieve post entity by id
        PostDto postDTO = postService.getPostById(postId);
        Post post = mapper.map(postDTO, Post.class);

        // retrieve comment by id
        Comment comment = commentRepository.findById(commentId).get();
        if(!comment.getPost().getId().equals(post.getId())){
            throw new IISException(HttpStatus.BAD_REQUEST, "Comment does not belongs to post");
        }

        commentRepository.delete(comment);
    }

    private CommentDto mapToDTO(Comment comment){
        CommentDto commentDto = mapper.map(comment, CommentDto.class);
        return  commentDto;
    }

    private Comment mapToEntity(CommentDto commentDto){
        Comment comment = mapper.map(commentDto, Comment.class);
        return  comment;
    }
}
