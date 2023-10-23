package limitedBook.controller.prod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import limitedBook.model.prod.ProdDAO;
import limitedBook.model.prod.ProdDTO;
import limitedBook.model.prod.ProdPageInfoVO;

public class ProdController extends HttpServlet implements Servlet {
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String actionType2 = request.getParameter("actionType2");
		
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("utf-8");
		
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		
		ProdDTO prod;
		ProdDAO prodDAO;
		ArrayList<ProdDTO> prodList; 
		
		ProdPageInfoVO bpiVO;
		
		if( session.getAttribute("prodPageInfoVO")==null){
			bpiVO = new ProdPageInfoVO();
			session.setAttribute("prodPageInfoVO", bpiVO);
		}
		else{
			bpiVO = (ProdPageInfoVO)session.getAttribute("prodPageInfoVO");
		}
		
		prodDAO = new ProdDAO();
		boolean result;
		String displayRecordCnt;
		int drc;
		String currentPageNo;
		int cpn;
		
		if(actionType2==null) {
		
			String imgDirPath = "C:\\Users\\Harc\\eclipse-workspace_web\\limitedBook\\src\\main\\webapp\\image\\";
			int maxSize = 1024 * 1024 * 5;
	//		String actionType = request.getParameter("actionType");
			
			MultipartRequest multi = new MultipartRequest(request,imgDirPath,maxSize,"utf-8",new DefaultFileRenamePolicy());
			
			String actionType = multi.getParameter("actionType");
			
			//이미지 파일 정보 변수 설정
			Enumeration<?> files = multi.getFileNames();
			
			String element = "";
			String filesystemName = "";
			String originalFileName = "";
			String contentType = "";
			long length = 0;
			
			if(files.hasMoreElements()){
				element = (String)files.nextElement();
				
				filesystemName = multi.getFilesystemName(element);
				originalFileName = multi.getOriginalFileName(element);
				contentType = multi.getContentType(element);
				length = multi.getFile(element).length();
				
			}	
			
			
			switch( actionType ){
			case "C": 
				prod = new ProdDTO();
			
				prod.setP_code(multi.getParameter("p_code"));
				prod.setP_name(multi.getParameter("p_name"));
				prod.setP_img(originalFileName);
				prod.setP_etc(multi.getParameter("p_etc"));
				prod.setP_date(multi.getParameter("p_date"));
				
				result = prodDAO.insertProd(prod);
				
				if(result == true){
					request.getRequestDispatcher("/contact.jsp").forward(request, response);
				}
				else{
					request.getRequestDispatcher("/view/etc/error.jsp").forward(request, response);
				}
				break;
				
			case "U_ID":
				
				prod = new ProdDTO();
				
				prod.setP_id(Integer.parseInt(multi.getParameter("p_id")));
				prod.setP_code(multi.getParameter("p_code"));
				prod.setP_name(multi.getParameter("p_name"));
				prod.setP_img(originalFileName);
				prod.setP_etc(multi.getParameter("p_etc"));
				prod.setP_date(multi.getParameter("p_date"));
				
				
				result = prodDAO.updateProd(prod);
				
				if(result == true){
					request.getRequestDispatcher("/ProdController.pr?actionType2=R4").forward(request, response);
				}
				else{
					request.getRequestDispatcher("/view/etc/error.jsp").forward(request,response);
				}
				break;
		}
		}else {
			
			switch( actionType2 ){
			case "R":
				
				prodList = prodDAO.getProdList();
				
				request.setAttribute("prodList", prodList);
				request.getRequestDispatcher("/view/prod/prod_r.jsp").forward(request, response);
				break;
			
			case "R4":
				
				currentPageNo = request.getParameter("currentPageNo");
				cpn = (currentPageNo == null)?0:Integer.parseInt(currentPageNo);
				
				bpiVO.setCurrentPageNo(cpn);
				bpiVO.adjPageInfo();
				
				prodList = prodDAO.getProdListForPage(bpiVO);
				
				request.setAttribute("prodList", prodList);
				request.getRequestDispatcher("/shop_rud.jsp").forward(request, response);
				break;	
				
			case "R_DRC":
				
				displayRecordCnt = request.getParameter("displayRecordCnt");
				drc = (displayRecordCnt == null)?10:Integer.parseInt(displayRecordCnt);
				
				bpiVO.setLimitCnt(drc);
				bpiVO.setCurrentPageNo(0);
				bpiVO.adjPageInfo();
				
				request.getRequestDispatcher("/shop.jsp").forward(request, response);
				break;
			
			case "D_ID":
				
				int p_id = Integer.parseInt(request.getParameter("p_id"));
				
				result = prodDAO.deleteProd(p_id);
				
				if(result == true){
					request.getRequestDispatcher("/shop.jsp").forward(request, response);
				}
				else {
					request.getRequestDispatcher("/view/etc/error.jsp").forward(request, response);
				}
				break;
				
			case "D":
				
				currentPageNo = request.getParameter("currentPageNo");
				cpn = (currentPageNo == null)?0:Integer.parseInt(currentPageNo);
				
				bpiVO.setCurrentPageNo(cpn);
				bpiVO.adjPageInfo();
				
				prodList = prodDAO.getProdListForPage(bpiVO);
				
				request.setAttribute("prodList", prodList);
				request.getRequestDispatcher("/view/prod/prod_d.jsp").forward(request, response);
				break;
				
			case "U":
				
				currentPageNo = request.getParameter("currentPageNo");
				cpn = (currentPageNo == null)?0:Integer.parseInt(currentPageNo);
				
				bpiVO.setCurrentPageNo(cpn);
				bpiVO.adjPageInfo();
				
				prodList = prodDAO.getProdListForPage(bpiVO);
				
				request.setAttribute("prodList", prodList);
				request.getRequestDispatcher("/view/prod/prod_u.jsp").forward(request, response);
				break;
				
			case "U2":
				
				p_id = Integer.parseInt(request.getParameter("p_id"));
				prod = prodDAO.getProd(p_id);
				
				request.setAttribute("prod", prod);
				request.getRequestDispatcher("/view/prod/prod_u2.jsp").forward(request, response);
				break;
				
				
			}
			
			
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		doProcess(request, response);
	}
}
