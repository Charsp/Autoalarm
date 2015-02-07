package com.swz.system.config.web.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.swz.data.vo.mysql.Info_blacklist;
import com.swz.data.vo.mysql.Info_sound;
import com.swz.data.vo.mysql.Info_user;
import com.swz.data.vo.mysql.Log_visit;
import com.swz.data.vo.mysql.Std_question;
import com.swz.data.vo.mysql.Std_questionpaper;
import com.swz.data.vo.mysql.Tr_question_paper;
import com.swz.voice.dao.ClientVisitDao;
import com.swz.voice.manager.ConfigDatas;
import com.swz.voice.model.PageInfo;
import com.swz.voice.model.RecAlarmSetting;
import com.swz.voice.model.VisitInfo;
import com.swz.web.controllerinf.TransactionControllerinf;

@RestController
public class TransactionController extends BaseController implements
		TransactionControllerinf {
	// 注入客户端
	private ClientVisitDao clientVisitDao;

	public ClientVisitDao getClientVisitDao() {
		return clientVisitDao;
	}

	@Resource
	public void setClientVisitDao(ClientVisitDao clientVisitDao) {
		this.clientVisitDao = clientVisitDao;
	}

	@RequestMapping(value = "/UserLogin", method = RequestMethod.GET)
	public Map<String, Object> login(HttpServletRequest request, Info_user user) {
		HttpSession session = request.getSession();

		// Cookie[] cookies = request.getCookies();
		// if (cookies != null) {
		// for (Cookie cookie : cookies) {
		// System.out.println(cookie.getName() + "  is  "
		// + cookie.getValue());
		// }
		// }

		// 重复登录
		if (session.getAttribute("UserId") != null) {
			return returnErrorCode(2002);
		}
		// 获取用户信息
		Integer userId = clientVisitDao.findByUser(user);
		if (userId != null) {
			// 登录成功
			session.setAttribute("UserId", userId);
			return returnErrorCode(0);
		}
		// 非法用户
		return returnErrorCode(2001);
	}

	/**
	 * UpdateUserInfo
	 * 
	 * @param request
	 * @param user
	 * @return 修改完成后，下次登录起作用
	 */
	@RequestMapping(value = "/UpdateUserInfo", method = RequestMethod.POST)
	public Map<String, Object> updae(HttpServletRequest request, Info_user user) {

		return returnErrorCode(2001);
	}

	/**
	 * 增加问题设置
	 * 
	 * @param request
	 *            用户识别信息
	 * @param questionpaper
	 *            新的调查问卷信息
	 * @return 更新的调查问卷信息
	 */
	@RequestMapping("/AddQuestionPaper")
	public Map<String, Object> addQuestionpaper(HttpServletRequest request,
			Std_questionpaper questionpaper) {
		if (AssertEqualNull(request.getSession().getAttribute("UserId"))) {
			// 非法用户
			return returnErrorCode(2001);
		}
		// 增加表，返回表id
		questionpaper.setCreate_user((Integer) request.getSession()
				.getAttribute("UserId"));
		questionpaper.setIsdefault((byte) 0);
		// 修改
		if (questionpaper.getPaper_id() != null) {
			Integer id = clientVisitDao.updateQuestionpaper(questionpaper);
			if (id != null && id > 0) {
				// 增加数据成功
				Map<String, Object> map = returnErrorCode(0);
				return map;
			}
		}
		// 新增加
		else {
			Integer id = clientVisitDao.saveQuestionpaper(questionpaper);
			if (id != null && id > 0) {
				// 增加数据成功
				Map<String, Object> map = returnErrorCode(0);
				map.put("paper_id", id);
				return map;
			}
		}

		// 增加数据失败
		return returnErrorCode(3002);
	}

	/**
	 * 增加问题
	 * 
	 * @param request
	 *            用户信息
	 * @param question
	 *            提交的问题内容
	 * @return 返回成功信息
	 */
	@RequestMapping("/AddQuestion")
	public Map<String, Object> addQustion(HttpServletRequest request,
			Std_question question) {
		if (AssertEqualNull(request.getSession().getAttribute("UserId"))) {
			// 非法用户
			return returnErrorCode(2001);
		}
		// 填入用户信息
		question.setCreate_user((Integer) request.getSession().getAttribute(
				"UserId"));
		question.setIsdelete((byte) 0);
		question.setUpdatetime(new Date());
		System.out.println(question);
		// 增加问题
		Integer id = clientVisitDao.saveQuestion(question);
		if (id != null && id > 0) {
			// 增加数据成功
			Map<String, Object> map = returnErrorCode(0);
			map.put("question_id", id);
			return map;
		}
		// 增加数据失败
		return returnErrorCode(3002);
	}

	/**
	 * 增加调查问卷
	 * 
	 * @param request
	 *            请求的用户信息
	 * @param question_paper
	 *            提交的调查问卷内容
	 * @return 返回成功信息
	 */
	@RequestMapping("/AddQuestionForpaper")
	public Map<String, Object> addQuestionForpaper(HttpServletRequest request,
			Tr_question_paper question_paper) {
		if (AssertEqualNull(request.getSession().getAttribute("UserId"))) {
			// 非法用户
			return returnErrorCode(2001);
		}

		// 增加表，返回表id
		Integer id = clientVisitDao.saveQuestion_paper(question_paper);
		if (id != null && id > 0) {
			// 增加数据成功
			Map<String, Object> map = returnErrorCode(0);
			map.put("question_id", id);
			return map;
		}
		// 增加数据失败
		return returnErrorCode(3002);
	}

	@RequestMapping(value = "/QueryPaper")
	public Map<String, Object> queryQuestionpaper(HttpServletRequest request) {
		if (AssertEqualNull(request.getSession().getAttribute("UserId"))) {
			// 非法用户
			return returnErrorCode(2001);
		}

		// 查询问题设置列表
		List<Std_questionpaper> questionpapers = clientVisitDao
				.getQuestionpapers();
		if (questionpapers != null) {
			// 查询成功
			Map<String, Object> map = returnErrorCode(0);
			map.put("questionpapers", questionpapers);
			return map;
		}
		// 查询失败
		return returnErrorCode(3005);
	}

	@RequestMapping(value = "/QueryQuestion")
	public Map<String, Object> queryQuestion(HttpServletRequest request) {
		if (AssertEqualNull(request.getSession().getAttribute("UserId"))) {
			// 非法用户
			return returnErrorCode(2001);
		}
		// 查询相关问题
		String paper_idString = request.getParameter("paper_id");

		try {
			// 唯一列表的问题集
			if (paper_idString != null) {
				Integer paper_id = Integer.parseInt(paper_idString);
				List<Std_question> questions = clientVisitDao
						.getQuestionsByQuery_id(paper_id);
				if (questions != null) {
					// 查询成功
					Map<String, Object> map = returnErrorCode(0);
					map.put("result", questions);
					return map;
				}
			}
			// 查询所有问题
			else {
				List<Std_question> questions = clientVisitDao.getQuestions();
				if (questions != null) {
					// 查询成功
					Map<String, Object> map = returnErrorCode(0);
					map.put("result", questions);
					return map;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return returnErrorCode(-1);
		}

		// 查询失败
		return returnErrorCode(3005);
	}

	@Override
	public Map<String, Object> delQuestionpaper(HttpServletRequest request) {

		if (AssertEqualNull(request.getSession().getAttribute("UserId"))) {
			// 非法用户
			return returnErrorCode(2001);
		} else if (AssertEqualNull(request.getSession()
				.getAttribute("UserPass"))) {
			// 没有权限
			return returnErrorCode(2009);
		}

		// 删除问卷
		String paper_idString = request.getParameter("paper_id");
		try {
			// 唯一列表的问题集
			if (!AssertEqualNull(paper_idString)) {
				Integer paper_id = Integer.parseInt(paper_idString);
				Integer deleteCol = clientVisitDao.delQuestionpaper(paper_id);
				if (deleteCol != null && deleteCol > 0) {
					// 删除成功
					return returnErrorCode(0);
				}
			}
		} catch (Exception e) {
			return returnErrorCode(-1);
		}
		// 删除失败
		return returnErrorCode(3003);
	}

	@Override
	public Map<String, Object> delQuestion(HttpServletRequest request) {

		if (AssertEqualNull(request.getSession().getAttribute("UserId"))) {
			// 非法用户
			return returnErrorCode(2001);
		} else if (AssertEqualNull(request.getSession()
				.getAttribute("UserPass"))) {
			// 没有权限
			return returnErrorCode(2009);
		}
		// 删除问题
		String question_idString = request.getParameter("question_id");
		try {
			// 唯一列表的问题集
			if (!AssertEqualNull(question_idString)) {
				Integer question_id = Integer.parseInt(question_idString);
				Integer deleteCol = clientVisitDao.delQuestion(question_id);
				if (deleteCol != null && deleteCol > 0) {
					// 删除成功
					return returnErrorCode(0);
				}
			}
		} catch (Exception e) {
			return returnErrorCode(-1);
		}
		// 删除失败
		return returnErrorCode(3003);
	}

	@Override
	public Map<String, Object> delQuestionForpaper(HttpServletRequest request,
			Tr_question_paper question_paper) {
		if (AssertEqualNull(request.getSession().getAttribute("UserId"))) {
			// 非法用户
			return returnErrorCode(2001);
		} else if (AssertEqualNull(request.getSession()
				.getAttribute("UserPass"))) {
			// 没有权限
			return returnErrorCode(2009);
		}
		// 从移除问卷中移除一个问题
		Integer deleteCol = clientVisitDao.delQustionRelation(question_paper);
		if (deleteCol != null && deleteCol > 0) {
			// 删除成功
			return returnErrorCode(0);
		}
		// 删除失败
		return returnErrorCode(3003);
	}

	// 方法二
	// FileOutputStream fs = new FileOutputStream(realPath + "/"
	// + file.getOriginalFilename());
	// byte[] buffer = new byte[1024 * 1024];
	// int byteread = 0;
	// InputStream stream = file.getInputStream();
	// while ((byteread = stream.read(buffer)) != -1) {
	// fs.write(buffer, 0, byteread);
	// fs.flush();
	// }
	// fs.close();
	// stream.close();
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.swz.web.controllerinf.TransactionControllerinf#addSound(javax.servlet
	 * .http.HttpServletRequest, com.swz.data.vo.mysql.Info_sound)
	 */
	@RequestMapping(value = "/UploadFile", method = RequestMethod.POST)
	public Map<String, Object> addSound(HttpServletRequest request,
			Info_sound sound) {

		if (AssertEqualNull(request.getSession().getAttribute("UserId"))) {
			// 非法用户
			return returnErrorCode(2001);
		}
		// 增加一条语音信息(上传文件) 有id为重命名 否则最新上传文件
		// String realPath = PropertiesAdapter.getKeyValue("sounduploadpath");
		String realPath = ConfigDatas.getMediaPath();
		/**** 路径 ****/
		sound.setSound_path(realPath);
		if (realPath.charAt(0) == '.' || realPath.charAt(0) == '/') {
			// System.out.println("相对路径" + realPath);
			realPath = request.getSession().getServletContext()
					.getRealPath(realPath);
		}

		File pathFile = new File(realPath);
		if (!pathFile.exists()) {
			pathFile.mkdirs();
		}

		MultipartFile file = sound.getFile();
		if (!file.isEmpty()) {
			try {
				/**** 文件名 ****/
				sound.setSound_name(file.getOriginalFilename());
				byte[] bytes = file.getBytes();
				/**
				 * 方法一
				 */
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File(realPath + File.separator
								+ sound.getSound_name())));
				stream.write(bytes);
				stream.close();
				/**
				 * 方法二
				 */

			} catch (IOException e) {
				return returnErrorCode(2007);
			}

			// 更新数据库
			Integer id = clientVisitDao.saveVoiceFile(sound);
			if (id != null && id > 0) {
				return returnErrorCode(0);
			} else {
				return returnErrorCode(3002);
			}
		}
		return returnErrorCode(2008);
	}

	@RequestMapping(value = "/SetDefaultPaper")
	public Map<String, Object> setDefaultPaper(HttpServletRequest request) {
		// 设置为默认报警id
		if (AssertEqualNull(request.getSession().getAttribute("UserId"))) {
			// 非法用户
			return returnErrorCode(2001);
		}

		String paperid = request.getParameter("paper_id");
		if (!AssertEqualNull(paperid)) {
			Integer paper_id = Integer.parseInt(paperid);
			Integer updateCol = clientVisitDao.setDefaultPaper(paper_id);
			if (updateCol != null && updateCol > 0) {
				// 更新成功
				// 更新配置文件内容
				List<VisitInfo> visitInfos = clientVisitDao
						.getVisitInfos(paper_id);
				if (visitInfos != null) {
					ConfigDatas.setVisitInfos(visitInfos);
					return returnErrorCode(0);
				}
				return returnErrorCode(3005);
			}
		}
		// 更新失败
		return returnErrorCode(3004);
	}

	@RequestMapping(value = "/AlarmSetting")
	public Map<String, Object> paramAlarmSetting(HttpServletRequest request,
			RecAlarmSetting alarmSetting) {
		/** 报警参数设置 **/
		// 每组回递报警个数（人数）
		ConfigDatas.setPeopleSum(alarmSetting.getTeamHandle());
		// 时间间隔(时间间隔)
		ConfigDatas.setPerSecond(alarmSetting.getTimeSpace());
		/** 报警语音设置 **/
		// 报警语音
		Info_sound info_sound = clientVisitDao.queryVoicebyID(alarmSetting
				.getAlarmSoundID());

		if (info_sound != null) {
			ConfigDatas.setAlarmSound(info_sound.getSound_path()
					+ File.separator + info_sound.getSound_name());

			System.out.println("报警语音为：" + info_sound.getSound_path()
					+ File.separator + info_sound.getSound_name());
		}
		// 确认语音
		info_sound = clientVisitDao.queryVoicebyID(alarmSetting
				.getConfirmSoundID());
		if (info_sound != null) {
			ConfigDatas.setConfirmSound(info_sound.getSound_path()
					+ File.separator + info_sound.getSound_name());
		}
		/** 过滤报警类型 **/
		ConfigDatas.setAlarmStyle(alarmSetting.getAlarmStyle());
		return returnErrorCode(0);

	}

	@RequestMapping(value = "/RestAlarmSetting")
	public Map<String, Object> restAlarmSetting() {
		Map<String, Object> map = returnErrorCode(0);
		RecAlarmSetting alarmSetting = new RecAlarmSetting();
		ConfigDatas.resetConfigData();
		alarmSetting.setAlarmStyle(ConfigDatas.getAlarmStyle());
		alarmSetting.setTeamHandle(ConfigDatas.getPeopleSum());
		alarmSetting.setTimeSpace(ConfigDatas.getPerSecond());
		map.put("result", alarmSetting);
		return map;
	}

	@RequestMapping(value = "/QuerySound")
	public Map<String, Object> querySound(HttpServletRequest request) {
		if (AssertEqualNull(request.getSession().getAttribute("UserId"))) {
			// 非法用户
			return returnErrorCode(2001);
		}
		List<Info_sound> info_sounds = clientVisitDao.queryVoiceFiles();
		if (info_sounds != null) {
			Map<String, Object> map = returnErrorCode(0);
			map.put("result", info_sounds);
			return map;
		}
		// 查询失败
		return returnErrorCode(3005);
	}

	@Override
	public Map<String, Object> delSound(HttpServletRequest request) {
		if (AssertEqualNull(request.getSession().getAttribute("UserId"))) {
			// 非法用户
			return returnErrorCode(2001);
		} else if (AssertEqualNull(request.getSession()
				.getAttribute("UserPass"))) {
			// 没有权限
			return returnErrorCode(2009);
		}

		// 删除问题
		String sound_idString = request.getParameter("sound_id");
		try {
			// 唯一列表的问题集
			if (!AssertEqualNull(sound_idString)) {
				Integer sound_id = Integer.parseInt(sound_idString);
				Integer deleteCol = clientVisitDao.delVoiceFile(sound_id);
				if (deleteCol != null && deleteCol > 0) {
					// 删除成功
					return returnErrorCode(0);
				}
			}
		} catch (Exception e) {
			return returnErrorCode(-1);
		}

		// 删除失败
		return returnErrorCode(3003);
	}

	@RequestMapping(value = "/QueryVisit")
	public Map<String, Object> queryLog_visit(PageInfo pageInfo) {
		// 页面默认20行数据
		if (pageInfo.getPageSize() == null) {
			pageInfo.setPageSize(20);
		}
		// 默认页面为第一页
		if (pageInfo.getCurrPage() == null) {
			pageInfo.setCurrPage(1);
		}
		// 直接返回数据
		List<Log_visit> log_visits = clientVisitDao.getVisits(pageInfo);
		if (log_visits != null) {
			Map<String, Object> map = returnErrorCode(0);
			map.put("result", log_visits);
			return map;
		}
		// 查询失败
		return returnErrorCode(3005);
	}

	@Override
	@Deprecated
	public Integer uploadVoiceFile(HttpServletRequest request) {
		return null;
	}

	@Override
	public Integer addLog_visit(Log_visit visit) {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value = "/AddBlack")
	public Map<String, Object> addBlackList(HttpServletRequest request,
			Info_blacklist blacklist) {
		if (AssertEqualNull(request.getSession().getAttribute("UserId"))) {
			// 非法用户
			return returnErrorCode(2001);
		}
		Long blackid = clientVisitDao.insertBlacklist(blacklist);
		if ((blackid != null)) {
			// 增加成功
			Map<String, Object> map = returnErrorCode(0);
			return map;
		}
		return returnErrorCode(3002);
	}

	@Override
	public Map<String, Object> delBlackList(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> queryBlackList(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> queryBoardInfo(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	// ************ 上面是调查问卷内容 以下是 ************ //
	@RequestMapping("/SetVisitInfo")
	public Map<String, Object> visitInfo(HttpServletRequest request) {

		// 分隔符为|,最后的|的个数为列的个数，一般只要一个电话号码而已
		String[] param = request.getParameter("request").split("//");
		List<String> trlList = new ArrayList<String>();
		for (String str : param) {
			trlList.add(str);
		}// 所要拨打的电话
		return returnErrorCode(0);
	}
}
