package controller;

import domain.Blog;
import domain.Member;
import repository.BlogDAOImpl;
import repository.MemberDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

//@WebServlet({"/blog/update.do", "/blog/update-form.do", "/blog/create.do", "/blog/read.do", "/blog/list.do", "/blog/delete.do","/blog/delete2.do"})
@WebServlet(urlPatterns = {"/blog/update.do", "/blog/update-form.do", "/blog/create.do", "/blog/read.do", "/blog/list.do", "/blog/delete.do","/blog/delete2.do"},
        name = "BlogController")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 30, maxRequestSize = 1024 * 1024 * 50)
// 2MB 단위로 쓰기, 1개 파일 최대 크기 30MB, 총 업로드 용량 50MB

public class BlogController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public BlogController() { super(); }

    BlogDAOImpl repository = null;
    MemberDAOImpl dao = null;
    Blog blog = null;
    List<Blog> blogList = null;

    private static final String SAVE_DIR = "files";
    private String partName = null;
    private String partValue = null;

    protected void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        repository = new BlogDAOImpl();
        dao = new MemberDAOImpl();
        String uri = request.getRequestURI();
        String action = uri.substring(uri.lastIndexOf("/") + 1);

        if(action.equals("list.do")) {
            int page = Integer.parseInt(request.getParameter("page"));
            if((blogList = repository.readList(page)) != null) {
                request.setAttribute("bloglist", blogList);
                request.getRequestDispatcher("list-view.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "블로그 목록 가져오기 오류 - 불편을 드려 죄송합니다.");
                request.getRequestDispatcher("../errors/message.jsp").forward(request, response);
            }
        }
        else if(action.equals("read.do")) {
            Blog retBlog = null;
            blog = new Blog();
            blog.setId(Integer.parseInt(request.getParameter("id")));
            if((retBlog = repository.read(blog)) != null) {
                request.setAttribute("blog", retBlog);
                request.getRequestDispatcher("read-view.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "블로그 읽기 오류 - 불편을 드려 죄송합니다.");
                request.getRequestDispatcher("../error/message.jsp").forward(request, response);
            }
        }
        else if(action.equals("create.do")) {
            String appPath = request.getServletContext().getRealPath("");
            String savePath = appPath + File.separator + SAVE_DIR;

            File fileSaveDir = new File(savePath);
            if( !fileSaveDir.exists() ) {
                fileSaveDir.mkdir();
            }

            Collection<Part> parts = request.getParts();
            for (Part part : parts) {
                partName = part.getName(); // 파라미터의 이름 가져오기 : productImage
                if(part.getContentType() != null) {
                    // 파일 부분을 처리
                    partValue = getFileName(part); // part 객체로 부터 값(파일 이름)을 가져옴
                    if(partValue != null && !partValue.isEmpty()) {
                        part.write(savePath + File.separator + partValue); // 업로드 담당하는 메소드
                    }
                }
                else {
                    // 파일이 아닌 파라미터 처리
                    partValue = request.getParameter(partName);
                }
                request.setAttribute(partName, partValue); // productImage
            }

            blog = new Blog();
            blog.setTitle((String) request.getAttribute("title"));
            blog.setContent((String) request.getAttribute("content"));
            blog.setFilepath((String) request.getAttribute("filepath"));
            blog.setBlogger((String) request.getAttribute("blogger"));
            blog.setRegDateTime(java.sql.Timestamp.valueOf((String) request.getAttribute("regDateTime")));
            System.out.println(blog.getRegDateTime().toString());

            if(repository.create(blog) > 0) {
                response.sendRedirect("list.do");// 상품 등록 성공, insert문 정상 동작
            } else {
                request.setAttribute("message", "블로그 등록 오류 - 불편을 드려 죄송합니다.");
                request.getRequestDispatcher("../errors/message.jsp").forward(request, response);
            }
        }
        else if(action.equals("update-form.do")) {
            Blog retBlog = null;
            blog = new Blog();
            blog.setId(Integer.parseInt(request.getParameter("id")));
            if((retBlog = repository.read(blog)) != null) {
                request.setAttribute("blog", retBlog);
                request.getRequestDispatcher("update-form.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "블로그 업데이트를 위한 읽기 오류 - 불편을 드려 죄송합니다.");
                request.getRequestDispatcher("../error/message.jsp").forward(request, response);
            }
        }
        else if(action.equals("update.do")) {
            String appPath = request.getServletContext().getRealPath(".");
            String savePath = appPath + File.separator + SAVE_DIR;

            File fileSaveDir = new File(savePath);
            if( !fileSaveDir.exists() ) {
                fileSaveDir.mkdir();
            }

            Collection<Part> parts = request.getParts();
            for (Part part : parts) {
                partName = part.getName(); // 파라미터의 이름 가져오기 : productImage
                if(part.getContentType() != null) {
                    // 파일 부분을 처리
                    partValue = getFileName(part); // part 객체로 부터 값(파일 이름)을 가져옴
                    if(partValue != null && !partValue.isEmpty()) {
                        System.out.println(savePath + File.separator + partValue);
                        part.write(savePath + File.separator + partValue); // 업로드 담당하는 메소드
                    }
                }
                else {
                    // 파일이 아닌 파라미터 처리
                    partValue = request.getParameter(partName);
                }
                request.setAttribute(partName, partValue); // productImage
            }

            blog = new Blog();
            blog.setId(Integer.parseInt((String) request.getAttribute("id")));
            blog.setTitle((String) request.getAttribute("title"));
            blog.setContent((String) request.getAttribute("content"));
            blog.setFilepath((String) request.getAttribute("filepath"));
            blog.setBlogger((String) request.getAttribute("blogger"));
            blog.setRegDateTime(java.sql.Timestamp.valueOf((String) request.getAttribute("regDateTime")));

            System.out.println(java.sql.Timestamp.valueOf((String) request.getAttribute("regDateTime")));

            if(repository.update(blog) > 0) {
                request.setAttribute("blog", blog);
                request.getRequestDispatcher("read-view.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "블로그 업데이트 오류 - 불편을 드려 죄송합니다.");
                request.getRequestDispatcher("../error/message.jsp").forward(request, response);
            }
        }
        else if(action.equals("delete.do")) {
            Blog retBlog = null;
            blog = new Blog();
            blog.setId(Integer.parseInt(request.getParameter("id")));
            if(repository.delete(blog) > 0) {
                request.setAttribute("blog", blog);
                request.getRequestDispatcher("list.do").forward(request, response);
            } else {
                request.setAttribute("message", "블로그 업데이트 오류 - 불편을 드려 죄송합니다.");
                request.getRequestDispatcher("../error/message.jsp").forward(request, response);
            }
        }
        else if(action.equals("delete2.do")) { // delete2.do = 작성자가 아니더라도 작성자의 비밀번호를 입력하면 삭제가능하도록 만든 기능
            blog = new Blog(); //새로은 blog 객체 생성
            blog.setId(Integer.parseInt(request.getParameter("id"))); //form을 통해 전달된 id값을 가져오기

            String email = request.getParameter("email"); //삭제하려는 게시글의 blog.blogger 를 가져오기
            String pw = request.getParameter("pw");

            Member m = new Member(); //새로운 member 객체 생성
            m.setEmail(email);
            m.setPw(pw);

            Member retMember = null;
            if((retMember = dao.read(m)) != null && pw.equals(retMember.getPw())){ //멤버 m의 이메일과 비밀번호로 로그인이 되고 and 로그인된 멤버의 비밀번호와 앞서 페이지에서 기입한 비밀번호가 같은지 check
                if (repository.delete(blog) > 0) { //BlogDAOImpl에서 delete를 Id 값으로 집어넣어, 삭제가 된다면
                    request.getRequestDispatcher("../blog/list.do").forward(request, response); // 블로그리스트로 이동
                    //request.getRequestDispatcher("list.do").forward(request, response);
                } else {
                    request.setAttribute("message", "블로그 업데이트 오류 - 불편을 드려 죄송합니다.");
                    request.getRequestDispatcher("../error/message.jsp").forward(request, response);
                }
            }

        }

        else {
            request.setAttribute("message", "잘못된 요청입니다. 확인하시기 바랍니다.");
            request.getRequestDispatcher("../error/message.jsp").forward(request, response);
        }
    }

    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
                // return s.substring(s.indexOf("=") + 1).trim().replace("\"",  "");
                // ;filename="induk.txt" -> induk.txt" -> " 교체 함  -> induk.txt
            }
        }
        return "";
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doService(request, response);
        // tomcat 9에서는 conf/server.xml의 URIEncoding=UTF-8 설정이 없어도 Get 방식으로 전송 시  문제가 없음
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doService(request, response);
    }

}

