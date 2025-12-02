 

package com.auto.mall.service;

import com.auto.mall.mapper.CommentMapper;
import com.auto.mall.model.Comment;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CommentService extends ServiceImpl<CommentMapper, Comment> {
    public CommentService() {
    }
}
