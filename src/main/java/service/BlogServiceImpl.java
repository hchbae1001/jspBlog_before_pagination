package service;

import domain.Blog;

import java.util.List;

public class BlogServiceImpl implements BlogService {
    @Override
    public Blog getBlog(long id) {
        return null;
    }

    @Override
    public List<Blog> getBlogs() {
        return null;
    }

    @Override
    public List<Blog> getBlogsByTitle(String title) {
        return null;
    }

    @Override
    public List<Blog> getBlogByBlogger(String blogger) {
        return null;
    }

    @Override
    public List<Blog> getBlogByPage(int index, int size) {
        return null;
    }

    @Override
    public int postBlog(Blog blog) {
        return 0;
    }

    @Override
    public int updateBlog(Blog blog) {
        return 0;
    }

    @Override
    public int deleteBlog(long id) {
        return 0;
    }
}
