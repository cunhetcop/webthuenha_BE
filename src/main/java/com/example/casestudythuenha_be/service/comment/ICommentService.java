package com.example.casestudythuenha_be.service.comment;

import com.example.casestudythuenha_be.IGeneralService;
import com.example.casestudythuenha_be.model.Comment;
import com.example.casestudythuenha_be.model.Order;

public interface ICommentService extends IGeneralService<Comment> {
    public Iterable<Comment> CommentByHouseId(Long id);
    public Iterable<Order> createComment(Long id, Long houses_id);
    Iterable<Comment> getListCommentByHouseOfUserId(Long userId, Long start);
    Iterable<Comment> getAllByCommentAndIsReadTrue(Long userId);
    Iterable<Comment> getAllByCommentAndIsReadFalse(Long userId);

    Iterable<Comment> getCommentByHouseId(Long id, long start);
}
