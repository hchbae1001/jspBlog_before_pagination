package repository;

import domain.Blog;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BlogDAOImpl extends DAOImplOracle implements BlogDAO {
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public BlogDAOImpl() {
        this.conn = getConnection();
    }

    @Override
    public int create(Blog blog) {
        int rows = 0;
        String sql = "insert into b201712045 values(seq_b201712045.nextval, ?, ?, ?, ?, ?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, blog.getTitle());
            pstmt.setString(2, blog.getContent());
            pstmt.setString(3, blog.getFilepath());
            pstmt.setString(4, blog.getBlogger());
            pstmt.setTimestamp(5, blog.getRegDateTime());
            rows = pstmt.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public Blog read(Blog blog) {
        Blog retBlog = null;

        String sql = "select * from b201712045 where id='" + blog.getId()  + "'";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()) { // 다음 record값을 접근
                // rs : record 집합, rs.getString(1) : 현재 레코드의 첫번재 필드 값
                retBlog = new Blog();
                retBlog.setId(rs.getInt(1)); // rs.getString("<field_name>"); 필드이름로도 가능
                retBlog.setTitle(rs.getString(2)); // 생성 시 필드 순서
                retBlog.setContent(rs.getString(3));
                retBlog.setFilepath(rs.getString(4));
                retBlog.setBlogger(rs.getString(5));;
                retBlog.setRegDateTime(rs.getTimestamp(6));
            }
        } catch (SQLException e) {			e.printStackTrace();		}
        finally {			this.closeResources(conn, stmt, pstmt, rs);		}
        return retBlog;
    }

    @Override
    public List<Blog> readList(int page) {
        int start = 1 + (page-1)*3;
        int end = 3*page;
        List<Blog> blogList = null;
        Blog retBlog = null;

        String sql = "SELECT * FROM (SELECT ROWNUM NUM, Blog.* FROM (SELECT * FROM b201712045 order by id desc)Blog) where NUM between ? and ?";
        try {
            stmt = null;
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,start);
            pstmt.setInt(2,end);
            rs = pstmt.executeQuery();
            blogList = new ArrayList<Blog>();
            while(rs.next()) { // 다음 record값을 접근
                // rs : record 집합, rs.getString(1) : 현재 레코드의 첫번재 필드 값
                retBlog = new Blog();
                retBlog.setId(rs.getInt(1)); // rs.getString("<field_name>"); 필드이름로도 가능
                retBlog.setTitle(rs.getString(2)); // 생성 시 필드 순서
                retBlog.setContent(rs.getString(3));
                retBlog.setFilepath(rs.getString(4));
                retBlog.setBlogger(rs.getString(5));;
                retBlog.setRegDateTime(rs.getTimestamp(6));
                blogList.add(retBlog);
            }
        } catch (SQLException e) {			e.printStackTrace();		}
        finally {			this.closeResources(conn, stmt, pstmt, rs);		}
        return blogList;
    }

    @Override
    public int update(Blog blog) {
        int rows = 0;
        String sql = "update b201712045 set title=?, content=?, filepath=?, reg_date_time=? where id=?";
        //TO_TIMESTAMP('2019-12-15 12:00:00.0', 'YYYY-MM-DD HH24:MI:SS.FF3')
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, blog.getTitle());
            pstmt.setString(2, blog.getContent());
            pstmt.setString(3, blog.getFilepath());
            pstmt.setTimestamp(4, blog.getRegDateTime());
            pstmt.setLong(5, blog.getId());
            rows = pstmt.executeUpdate();
            if(rows == 0)
                System.out.println(blog.getTitle() + "error : " + blog.getRegDateTime() + ":::" + blog.getId());
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int delete(Blog blog) {
        int rows = 0;
        String sql = "delete from b201712045 where id=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, blog.getId());
            rows = pstmt.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

}
