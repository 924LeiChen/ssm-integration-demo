package cn.itheima.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.itheima.pojo.Items;
import cn.itheima.service.ItemsService;
import cn.itheima.vo.QueryVo;

@Controller
public class ItemsController {

	@Autowired
	private ItemsService itmesService;
	
	@RequestMapping("/list")
	public ModelAndView itemsList() throws Exception{
		List<Items> list = itmesService.list();
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("itemList", list);
		modelAndView.setViewName("itemList");
		
		return modelAndView;
	}
	
	/**
	 * springMvc涓粯璁ゆ敮鎸佺殑鍙傛暟绫诲瀷:涔熷氨鏄鍦╟ontroller鏂规硶涓彲浠ュ姞鍏ヨ繖浜涗篃鍙互涓嶅姞,  鍔犱笉鍔犵湅鑷繁闇�涓嶉渶瑕�,閮借.
	 *HttpServletRequest
	 *HttpServletResponse
	 *HttpSession
	 *Model
	 */
	@RequestMapping("/itemEdit")
	public String itemEdit(HttpServletRequest reuqest, 
			 Model model) throws Exception{
		
		String idStr = reuqest.getParameter("id");
		Items items = itmesService.findItemsById(Integer.parseInt(idStr));
		
		//Model妯″瀷:妯″瀷涓斁鍏ヤ簡杩斿洖缁欓〉闈㈢殑鏁版嵁
		//model搴曞眰鍏跺疄灏辨槸鐢ㄧ殑request鍩熸潵浼犻�掓暟鎹�,浣嗘槸瀵箁equest鍩熻繘琛屼簡鎵╁睍.
		model.addAttribute("item", items);
		
		//濡傛灉springMvc鏂规硶杩斿洖涓�涓畝鍗曠殑string瀛楃涓�,閭ｄ箞springMvc灏变細璁や负杩欎釜瀛楃涓插氨鏄〉闈㈢殑鍚嶇О
		return "editItem";
	}
	
	//springMvc鍙互鐩存帴鎺ユ敹鍩烘湰鏁版嵁绫诲瀷,鍖呮嫭string.spirngMvc鍙互甯綘鑷姩杩涜绫诲瀷杞崲.
	//controller鏂规硶鎺ユ敹鐨勫弬鏁扮殑鍙橀噺鍚嶇О蹇呴』瑕佺瓑浜庨〉闈笂input妗嗙殑name灞炴�у��
	//public String update(Integer id, String name, Float price, String detail) throws Exception{
	
	//spirngMvc鍙互鐩存帴鎺ユ敹pojo绫诲瀷:瑕佹眰椤甸潰涓奿nput妗嗙殑name灞炴�у悕绉板繀椤荤瓑浜巔ojo鐨勫睘鎬у悕绉�
	@RequestMapping("/updateitem")
	public String update(Items items) throws Exception{
		itmesService.updateItems(items);
		
		return "success";
	}
	
	//濡傛灉Controller涓帴鏀剁殑鏄疺o,閭ｄ箞椤甸潰涓奿nput妗嗙殑name灞炴�у�艰绛変簬vo鐨勫睘鎬�.灞炴��.灞炴��.....
	@RequestMapping("/search")
	public String search(QueryVo vo) throws Exception{
		System.out.println(vo);
		return "";
	}
}
