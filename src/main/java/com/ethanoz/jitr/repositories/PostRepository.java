package com.ethanoz.jitr.repositories;

import com.ethanoz.jitr.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
