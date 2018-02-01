package model.ajax;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Command;

public class AjaxMemberCommand implements Command{
	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		/* Member에 대한 정보를 Json으로 뿌려줄 수 있도록 함. */
		String json = "[\n" + 
				"  {\n" + 
				"    \"id\": 65,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 1,\n" + 
				"    \"team1\": \"목회행정\",\n" + 
				"    \"team2\": \"SMART 사역팀\",\n" + 
				"    \"pastor\": \"최성석슈퍼울트라천재\",\n" + 
				"    \"elder\": \"민문기\",\n" + 
				"    \"cheif\": \"장부은\",\n" + 
				"    \"manager\": \"정상호\",\n" + 
				"    \"excutors\": \"고건,이관수,정영택,박일환,곽유신,구자룡,길아라,김동환,김수정,김수현,김유선,김일현,김종환,김창섭,김태훈,김현주,김혜원,김효정,남승범,노익현,맹호규,문유선,방기영,배현선,송우영,양웅,양희주,오석주,오영미,유경아,윤호석,이경희,이남희,이성은,이성희,이일형,이재혁,이준호,이현민,이현우,이호수,임채윤,장효중,정연문,정재현,정지현,차원만,최재훈,한별,함상석,함정호,홍민희\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 66,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 1,\n" + 
				"    \"team1\": \"목회행정\",\n" + 
				"    \"team2\": \"홍보관\",\n" + 
				"    \"pastor\": \"조호영\",\n" + 
				"    \"elder\": \"송종환\",\n" + 
				"    \"cheif\": \"한명숙\",\n" + 
				"    \"manager\": \"김영화\",\n" + 
				"    \"excutors\": \"강의숙,강윤정,권동희,김유정,김유림,김지희,김도숙,김명원,김정애,남지영,민선영,박미림,박선진,박미경,백미경,송영이,오미영,유수정,유용선,이은주,이정안,이숙희,이홍선,이혜정,조성숙,정현주,최승연,최현선,한미정,황미경\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 67,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 1,\n" + 
				"    \"team1\": \"목회행정\",\n" + 
				"    \"team2\": \"IT지원팀\",\n" + 
				"    \"pastor\": \"최성석\",\n" + 
				"    \"elder\": \"박일환\",\n" + 
				"    \"cheif\": \"유용\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"채민,조태완,이상진,김태오,손명우,김성진,김소영\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 68,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 0,\n" + 
				"    \"team1\": \"목회본부\",\n" + 
				"    \"team2\": \"목회비서실\",\n" + 
				"    \"pastor\": \"김소리\",\n" + 
				"    \"elder\": \"\",\n" + 
				"    \"cheif\": \"\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"정재륜,김영란,조희영,강근식\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 69,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 0,\n" + 
				"    \"team1\": \"목회본부\",\n" + 
				"    \"team2\": \"목회기획실\",\n" + 
				"    \"pastor\": \"이기원\",\n" + 
				"    \"elder\": \"이남식\",\n" + 
				"    \"cheif\": \"\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"김소리,김재석,노희태,신동식,양재경,여성민,이준호,조호영\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 70,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 0,\n" + 
				"    \"team1\": \"목회본부\",\n" + 
				"    \"team2\": \"캠퍼스본부\",\n" + 
				"    \"pastor\": \"박종길\",\n" + 
				"    \"elder\": \"\",\n" + 
				"    \"cheif\": \"\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"이상진,박형준,신기섭,박태영,안광국,김종민,서경남,노치형,도육환,노규석\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 71,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 0,\n" + 
				"    \"team1\": \"목회본부\",\n" + 
				"    \"team2\": \"영성수련회\",\n" + 
				"    \"pastor\": \"박종길\",\n" + 
				"    \"elder\": \"백홍기\",\n" + 
				"    \"cheif\": \"\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"이기훈,이기원,손신국,박철웅\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 72,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 0,\n" + 
				"    \"team1\": \"목회본부\",\n" + 
				"    \"team2\": \"Acts29_해외비전교회\",\n" + 
				"    \"pastor\": \"박종길,윤길중\",\n" + 
				"    \"elder\": \"강의선\",\n" + 
				"    \"cheif\": \"\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"김홍주,권득한,김재일,나상권,박태성,신무환,신민호,윤형주,이길수,이한열,임호열,장우진,정상기,최현재\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 73,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 0,\n" + 
				"    \"team1\": \"목회본부\",\n" + 
				"    \"team2\": \"Acts29_러브소나타\",\n" + 
				"    \"pastor\": \"박종길,깅경훈,이정환,최성석\",\n" + 
				"    \"elder\": \"윤영섭\",\n" + 
				"    \"cheif\": \"유의준\",\n" + 
				"    \"manager\": \"박성호\",\n" + 
				"    \"excutors\": \"김영숙,김일호,김재일,김하중,김희준,나문채,류필분,박순길,박일환,박상송,손한기,신민호,요시하라마나부,유병진,이승배,이원장,이용경,이은일,조성수,정대서,정영택,조문자,함태경,홍성덕,황상윤\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 74,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 0,\n" + 
				"    \"team1\": \"목회본부\",\n" + 
				"    \"team2\": \"Acts29_CMN\",\n" + 
				"    \"pastor\": \"박종길,양성민\",\n" + 
				"    \"elder\": \"박영한\",\n" + 
				"    \"cheif\": \"정동형\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"김두진,김원,문창호,박용원,손한기,신덕신,양유식,오성훈,윤기홍,윤주헌,이철,이경률,이원로,이은일,이희주,장광열,정문규,정파종,정희원,차준구,최중언,한덕종,허필우,권세윤,김동준,김병순,김선아,김충희,김택수,김형겸,남상옥,박명률,박영한,박해한,신학철,심형섭,안태환,우승엽,윤기홍,이대현,이우석,이정구,장동형,장동형,추적금,한덕종\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 75,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 0,\n" + 
				"    \"team1\": \"목회본부\",\n" + 
				"    \"team2\": \"장로아카데미\",\n" + 
				"    \"pastor\": \"박종길\",\n" + 
				"    \"elder\": \"이장로\",\n" + 
				"    \"cheif\": \"전구영\",\n" + 
				"    \"manager\": \"홍성호\",\n" + 
				"    \"excutors\": \"김명현,민문기,유재홍,이재규,정운섭\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 76,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 0,\n" + 
				"    \"team1\": \"사역본부\",\n" + 
				"    \"team2\": \"예배본부\",\n" + 
				"    \"pastor\": \"김재석\",\n" + 
				"    \"elder\": \"박상송\",\n" + 
				"    \"cheif\": \"\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 77,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 0,\n" + 
				"    \"team1\": \"사역본부\",\n" + 
				"    \"team2\": \"양육본부\",\n" + 
				"    \"pastor\": \"박태영\",\n" + 
				"    \"elder\": \"안용태\",\n" + 
				"    \"cheif\": \"서명수\",\n" + 
				"    \"manager\": \"이종우\",\n" + 
				"    \"excutors\": \"박종길,이상준,이정환,박성은A,윤경숙,강부순,강찬석,박동현,박흥균,육동건,이한열,이헌규,이홍선\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 78,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 0,\n" + 
				"    \"team1\": \"사역본부\",\n" + 
				"    \"team2\": \"전도사역본부\",\n" + 
				"    \"pastor\": \"여성민\",\n" + 
				"    \"elder\": \"이인용\",\n" + 
				"    \"cheif\": \"\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"이인용,이수완,허필우,장경문,이태열,나영욱,김병옥,최민철,조청구,김용기,김상섭,백홍기,정재륜,박성천,양재경,한화수,김정숙,윤길중,김승훈,한영철,김태용,이기진,김영창\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 79,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 0,\n" + 
				"    \"team1\": \"사역본부\",\n" + 
				"    \"team2\": \"사회선교본부\",\n" + 
				"    \"pastor\": \"이기훈,유진아\",\n" + 
				"    \"elder\": \"권득한,장경식\",\n" + 
				"    \"cheif\": \"김춘택\",\n" + 
				"    \"manager\": \"강종도\",\n" + 
				"    \"excutors\": \"김상춘,김행자,김혜전,박은영,송은영,안윤진,이승애,이영희,이은미,이학철,이홍재,임원교,최미영,최혜옥,한성자,황덕신,황유선\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 80,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 0,\n" + 
				"    \"team1\": \"사역본부\",\n" + 
				"    \"team2\": \"장애인사역본부\",\n" + 
				"    \"pastor\": \"박철웅\",\n" + 
				"    \"elder\": \"김준홍\",\n" + 
				"    \"cheif\": \"\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"김성균,김준규,김철민,박상송,배문,심춘보,이승배,이정근,허영남,이범식,이자형,임정민,조태형\\t\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 81,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 0,\n" + 
				"    \"team1\": \"사역본부\",\n" + 
				"    \"team2\": \"회복사역본부\",\n" + 
				"    \"pastor\": \"이기원\",\n" + 
				"    \"elder\": \"권용한\",\n" + 
				"    \"cheif\": \"이병국\",\n" + 
				"    \"manager\": \"이정석,임상범\",\n" + 
				"    \"excutors\": \"권용갑,김성진,김인선,김지현,김지홍,김창성,김창욱,박성규,박승우,서성렬,서영희,성주명,신영선,오민,이성광,이정환,이찬우,이헌규,이현대,이화영,정재욱,최용준\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 82,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 0,\n" + 
				"    \"team1\": \"사역본부\",\n" + 
				"    \"team2\": \"가정사역본부\",\n" + 
				"    \"pastor\": \"\",\n" + 
				"    \"elder\": \"\",\n" + 
				"    \"cheif\": \"\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 83,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 0,\n" + 
				"    \"team1\": \"사역본부\",\n" + 
				"    \"team2\": \"차세대사역본부\",\n" + 
				"    \"pastor\": \"노희태\",\n" + 
				"    \"elder\": \"이길수\",\n" + 
				"    \"cheif\": \"\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 84,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 0,\n" + 
				"    \"team1\": \"사역본부\",\n" + 
				"    \"team2\": \"대학청년사역본부\",\n" + 
				"    \"pastor\": \"김승수\",\n" + 
				"    \"elder\": \"심희돈\",\n" + 
				"    \"cheif\": \"최민석,양상식\",\n" + 
				"    \"manager\": \"김여우\",\n" + 
				"    \"excutors\": \"\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 85,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 0,\n" + 
				"    \"team1\": \"사역본부\",\n" + 
				"    \"team2\": \"국제사역본부\",\n" + 
				"    \"pastor\": \"스티브차\",\n" + 
				"    \"elder\": \"송영태,정영택,김재일,신민호,문성기\",\n" + 
				"    \"cheif\": \"\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 86,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 0,\n" + 
				"    \"team1\": \"사역본부\",\n" + 
				"    \"team2\": \"영성사역본부\",\n" + 
				"    \"pastor\": \"조호영\",\n" + 
				"    \"elder\": \"이남수\",\n" + 
				"    \"cheif\": \"\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"권오향,김정희,김현실,유영순,이윤재,김혜경,배순양,윤치연,이미령,이진이,허영은,김남정,김영미,김영심,김정숙,백은기,유란희,이규영,이미숙,조미영,진선미,차소연\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 87,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 0,\n" + 
				"    \"team1\": \"사역본부\",\n" + 
				"    \"team2\": \"선교사역본부\",\n" + 
				"    \"pastor\": \"김홍주\",\n" + 
				"    \"elder\": \"전영수\",\n" + 
				"    \"cheif\": \"\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"도육환,황종연,신원석,손정훈,강일영,노규석,김도균,김창옥,전영수,윤현덕,정대서,김기호,신헌승,민문기,김병순,임훈,이승배\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 88,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 1,\n" + 
				"    \"team1\": \"목회행정\",\n" + 
				"    \"team2\": \"목회행정실\",\n" + 
				"    \"pastor\": \"이준호\",\n" + 
				"    \"elder\": \"정진호\",\n" + 
				"    \"cheif\": \"김경렬\",\n" + 
				"    \"manager\": \"김현지\",\n" + 
				"    \"excutors\": \"\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 89,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 1,\n" + 
				"    \"team1\": \"목회행정\",\n" + 
				"    \"team2\": \"목회지원\",\n" + 
				"    \"pastor\": \"이준호\",\n" + 
				"    \"elder\": \"정진호\",\n" + 
				"    \"cheif\": \"김향선\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 90,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 1,\n" + 
				"    \"team1\": \"목회행정\",\n" + 
				"    \"team2\": \"사역지원\",\n" + 
				"    \"pastor\": \"이준호\",\n" + 
				"    \"elder\": \"정진호\",\n" + 
				"    \"cheif\": \"이정아\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 91,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 1,\n" + 
				"    \"team1\": \"목회행정\",\n" + 
				"    \"team2\": \"행사민원지원\",\n" + 
				"    \"pastor\": \"이준호\",\n" + 
				"    \"elder\": \"정진호\",\n" + 
				"    \"cheif\": \"김연선\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 92,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 1,\n" + 
				"    \"team1\": \"목회행정\",\n" + 
				"    \"team2\": \"재정국\",\n" + 
				"    \"pastor\": \"이준호\",\n" + 
				"    \"elder\": \"장경식\",\n" + 
				"    \"cheif\": \"문향숙\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 93,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 1,\n" + 
				"    \"team1\": \"목회행정\",\n" + 
				"    \"team2\": \"방송영상지원\",\n" + 
				"    \"pastor\": \"이준호\",\n" + 
				"    \"elder\": \"김영수\",\n" + 
				"    \"cheif\": \"류승호\",\n" + 
				"    \"manager\": \"양성수\",\n" + 
				"    \"excutors\": \"\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 94,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 1,\n" + 
				"    \"team1\": \"목회행정\",\n" + 
				"    \"team2\": \"도서관\",\n" + 
				"    \"pastor\": \"이준호\",\n" + 
				"    \"elder\": \"김형중\",\n" + 
				"    \"cheif\": \"형세우\",\n" + 
				"    \"manager\": \"이종연\",\n" + 
				"    \"excutors\": \"\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 95,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 1,\n" + 
				"    \"team1\": \"목회행정\",\n" + 
				"    \"team2\": \"디자인실\",\n" + 
				"    \"pastor\": \"이준호,박성은\",\n" + 
				"    \"elder\": \"한벽진\",\n" + 
				"    \"cheif\": \"윤여희\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 96,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 1,\n" + 
				"    \"team1\": \"목회행정\",\n" + 
				"    \"team2\": \"신문사\",\n" + 
				"    \"pastor\": \"이준호,김소리\",\n" + 
				"    \"elder\": \"문창극\",\n" + 
				"    \"cheif\": \"김남원\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 97,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 2,\n" + 
				"    \"team1\": \"성인공동체\",\n" + 
				"    \"team2\": \"본부운영위원회\",\n" + 
				"    \"pastor\": \"박종길\",\n" + 
				"    \"elder\": \"이한열\",\n" + 
				"    \"cheif\": \"\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 98,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 2,\n" + 
				"    \"team1\": \"성인공동체\",\n" + 
				"    \"team2\": \"서빙고_운영위원회\",\n" + 
				"    \"pastor\": \"박종길\",\n" + 
				"    \"elder\": \"이관수\",\n" + 
				"    \"cheif\": \"이기호\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"최득린,심상달,이관수,한규종,윤현덕,최현재,이길수,박순길,신무환,이영복,장경식,이영찬,김경자,김남명,임창수,신광숙,이희주,권오연,김숙희,김양수,김난영,문영주,김지선,정승옥,이미정,김정숙,정혜경,강승경\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 99,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 2,\n" + 
				"    \"team1\": \"성인공동체\",\n" + 
				"    \"team2\": \"서빙고_양육운영팀\",\n" + 
				"    \"pastor\": \"박종길\",\n" + 
				"    \"elder\": \"이관수\",\n" + 
				"    \"cheif\": \"안광식\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"강석훈,강희택,김성원,신문순,김영석,구본영,이동언,최동현,장문성,신학철,김현국,김진연,임우성,이경률,손성규,김철환,유주석,유,,진,김종만,박정신,양상훈,강은택,류병완,차현진,김병식,전,,존,이승대,한연순,이인숙,남정희,고두연,홍은옥,박윤희,전사라,박혜경,이현수,조희성,손은경,권성희,최연희,김희권,김수미,서현주,권녹희,강향조,최승연,김성숙,신미혜,최정현,김주형,정숙영,권혜령,최구슬,김지혜,안숙향,송혜경,이지연,김은영,어원경,조민주,권녹희,황윤정,조윤세,김현정,김미원\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 100,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 2,\n" + 
				"    \"team1\": \"성인공동체\",\n" + 
				"    \"team2\": \"성동광진_운영위원회\",\n" + 
				"    \"pastor\": \"이기훈\",\n" + 
				"    \"elder\": \"이태환\",\n" + 
				"    \"cheif\": \"고동영\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"김병옥,문형남,박상송,이태환,이한열,전장하,정영열,조청구,김영옥,김현종,박재우,김이준,신정묵,신지현,김상춘,강명옥,박진호,고동영,서호양,임용빈,지연실\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 101,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 2,\n" + 
				"    \"team1\": \"성인공동체\",\n" + 
				"    \"team2\": \"성동광진_양육운영팀\",\n" + 
				"    \"pastor\": \"이기훈\",\n" + 
				"    \"elder\": \"이태환\",\n" + 
				"    \"cheif\": \"이동현\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"강숙영,이판례,박성옥,박해동,김혜영,이성근,성명심\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 102,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 2,\n" + 
				"    \"team1\": \"성인공동체\",\n" + 
				"    \"team2\": \"강서_운영위원회\",\n" + 
				"    \"pastor\": \"황재명\",\n" + 
				"    \"elder\": \"전영수\",\n" + 
				"    \"cheif\": \"동두봉\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"구자윤,김미숙,박순,박진영,유연경,이창선,이철희,채홍장,김경희,박성의,이수연\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 103,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 2,\n" + 
				"    \"team1\": \"성인공동체\",\n" + 
				"    \"team2\": \"강서_양육운영팀\",\n" + 
				"    \"pastor\": \"황재명\",\n" + 
				"    \"elder\": \"전영수\",\n" + 
				"    \"cheif\": \"박범식\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 104,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 2,\n" + 
				"    \"team1\": \"성인공동체\",\n" + 
				"    \"team2\": \"이수_운영위원회\",\n" + 
				"    \"pastor\": \"최성석\",\n" + 
				"    \"elder\": \"최성완\",\n" + 
				"    \"cheif\": \"최인기\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"정윤채,우상근,안동혁,김효구,이상율,양웅,김복균,김성규,남춘희,정기삼,김재덕,위성규,이승배,이상준\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 105,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 2,\n" + 
				"    \"team1\": \"성인공동체\",\n" + 
				"    \"team2\": \"이수_양육운영팀\",\n" + 
				"    \"pastor\": \"최성석\",\n" + 
				"    \"elder\": \"최성완\",\n" + 
				"    \"cheif\": \"안동혁\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"김성규,김미영,이승배,유현미\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 106,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 2,\n" + 
				"    \"team1\": \"성인공동체\",\n" + 
				"    \"team2\": \"동작_운영위원회\",\n" + 
				"    \"pastor\": \"한화수\",\n" + 
				"    \"elder\": \"문충실\",\n" + 
				"    \"cheif\": \"이종택\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"서성렬,정운오,진종구,추교명,반상섭,오근,정의일,조영준,박은숙,성숙경,이문환\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 107,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 2,\n" + 
				"    \"team1\": \"성인공동체\",\n" + 
				"    \"team2\": \"동작_양육운영팀\",\n" + 
				"    \"pastor\": \"한화수\",\n" + 
				"    \"elder\": \"문충실\",\n" + 
				"    \"cheif\": \"추교명\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 108,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 2,\n" + 
				"    \"team1\": \"성인공동체\",\n" + 
				"    \"team2\": \"S브릿지_운영위원회\",\n" + 
				"    \"pastor\": \"강미향\",\n" + 
				"    \"elder\": \"이기준\",\n" + 
				"    \"cheif\": \"송현정\",\n" + 
				"    \"manager\": \"박민균,박태근\",\n" + 
				"    \"excutors\": \"\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 109,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 2,\n" + 
				"    \"team1\": \"성인공동체\",\n" + 
				"    \"team2\": \"S브릿지_양육운영팀\",\n" + 
				"    \"pastor\": \"강미향\",\n" + 
				"    \"elder\": \"이기중\",\n" + 
				"    \"cheif\": \"나은선\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 110,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 2,\n" + 
				"    \"team1\": \"성인공동체\",\n" + 
				"    \"team2\": \"한강_운영위원회\",\n" + 
				"    \"pastor\": \"문영재\",\n" + 
				"    \"elder\": \"이경찬\",\n" + 
				"    \"cheif\": \"김동우\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 111,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 2,\n" + 
				"    \"team1\": \"성인공동체\",\n" + 
				"    \"team2\": \"한강_양육운영팀\",\n" + 
				"    \"pastor\": \"문영재\",\n" + 
				"    \"elder\": \"이경찬\",\n" + 
				"    \"cheif\": \"최석훈\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 112,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 2,\n" + 
				"    \"team1\": \"성인공동체\",\n" + 
				"    \"team2\": \"중종로_운영위원회\",\n" + 
				"    \"pastor\": \"\",\n" + 
				"    \"elder\": \"\",\n" + 
				"    \"cheif\": \"\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 113,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 2,\n" + 
				"    \"team1\": \"성인공동체\",\n" + 
				"    \"team2\": \"중종로_양육운영팀\",\n" + 
				"    \"pastor\": \"김경훈\",\n" + 
				"    \"elder\": \"정문규\",\n" + 
				"    \"cheif\": \"오명\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 114,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 2,\n" + 
				"    \"team1\": \"성인공동체\",\n" + 
				"    \"team2\": \"일산_운영위원회\",\n" + 
				"    \"pastor\": \"손신국\",\n" + 
				"    \"elder\": \"박두원\",\n" + 
				"    \"cheif\": \"\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 115,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 2,\n" + 
				"    \"team1\": \"성인공동체\",\n" + 
				"    \"team2\": \"일산_양육운영팀\",\n" + 
				"    \"pastor\": \"손신국\",\n" + 
				"    \"elder\": \"박두원\",\n" + 
				"    \"cheif\": \"\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 116,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 2,\n" + 
				"    \"team1\": \"성인공동체\",\n" + 
				"    \"team2\": \"김포_운영위원회\",\n" + 
				"    \"pastor\": \"박성천\",\n" + 
				"    \"elder\": \"이규천\",\n" + 
				"    \"cheif\": \"\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 117,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 2,\n" + 
				"    \"team1\": \"성인공동체\",\n" + 
				"    \"team2\": \"김포_양육운영팀\",\n" + 
				"    \"pastor\": \"박성천\",\n" + 
				"    \"elder\": \"이규천\",\n" + 
				"    \"cheif\": \"\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 118,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 2,\n" + 
				"    \"team1\": \"성인공동체\",\n" + 
				"    \"team2\": \"가정사역_운영위원회\",\n" + 
				"    \"pastor\": \"최승구\",\n" + 
				"    \"elder\": \"이종길\",\n" + 
				"    \"cheif\": \"\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 119,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 2,\n" + 
				"    \"team1\": \"성인공동체\",\n" + 
				"    \"team2\": \"가정사역_양육운영팀\",\n" + 
				"    \"pastor\": \"최승구\",\n" + 
				"    \"elder\": \"이종길\",\n" + 
				"    \"cheif\": \"\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 120,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 2,\n" + 
				"    \"team1\": \"성인공동체\",\n" + 
				"    \"team2\": \"특별한초대_운영위원회\",\n" + 
				"    \"pastor\": \"정재륜,박성천\",\n" + 
				"    \"elder\": \"허필우\",\n" + 
				"    \"cheif\": \"\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 121,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 2,\n" + 
				"    \"team1\": \"성인공동체\",\n" + 
				"    \"team2\": \"특별한초대_양육운영팀\",\n" + 
				"    \"pastor\": \"정재륜,박성천\",\n" + 
				"    \"elder\": \"허필우\",\n" + 
				"    \"cheif\": \"\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  },\n" + 
				"  {\n" + 
				"    \"id\": 122,\n" + 
				"    \"campus\": 0,\n" + 
				"    \"department\": 2,\n" + 
				"    \"team1\": \"성인공동체\",\n" + 
				"    \"team2\": \"영등포구로_운영위원회\",\n" + 
				"    \"pastor\": \"여성민\",\n" + 
				"    \"elder\": \"박봉래\",\n" + 
				"    \"cheif\": \"김성진\",\n" + 
				"    \"manager\": \"\",\n" + 
				"    \"excutors\": \"\",\n" + 
				"    \"uploader\": \"woosan12\",\n" + 
				"    \"campusDisplay\": null,\n" + 
				"    \"departmentDisplay\": null\n" + 
				"  }\n" + 
				"]";
		
		Gson gson = new Gson();
		/* Json 배열을 DTO로 변경 */ 
		Member[] array = gson.fromJson(json, Member[].class);
		List<Member> listMember = Arrays.asList(array);
		
		/* 변경된 DTO배열을 json으로 변경 */
		String returnJson = gson.toJson(listMember);
		
		return returnJson;
	}
}


class Member{
	private int id;
	private int campus;
	private int department; 
	private String team1; 
	private String team2; 
	private String pastor; 
	private String elder; 
	private String cheif; 
	private String manager; 
	private String excutors; 
	private String uploader; 
	private String campusDisplay; 
	private String departmentDisplay; 
	
	@Override
	public String toString() {
		String ret = id + ":" + campus + ":" + department + ":" + team1 + ":" + team2 + ":" + pastor
				+ ":" + elder + ":" + cheif + ":" + manager + ":" + excutors + ":" + uploader + ":"
				+ campusDisplay + ":" + departmentDisplay; 
		return ret; 
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCampus() {
		return campus;
	}
	public void setCampus(int campus) {
		this.campus = campus;
	}
	public int getDepartment() {
		return department;
	}
	public void setDepartment(int department) {
		this.department = department;
	}
	public String getTeam1() {
		return team1;
	}
	public void setTeam1(String team1) {
		this.team1 = team1;
	}
	public String getTeam2() {
		return team2;
	}
	public void setTeam2(String team2) {
		this.team2 = team2;
	}
	public String getPastor() {
		return pastor;
	}
	public void setPastor(String pastor) {
		this.pastor = pastor;
	}
	public String getElder() {
		return elder;
	}
	public void setElder(String elder) {
		this.elder = elder;
	}
	public String getCheif() {
		return cheif;
	}
	public void setCheif(String cheif) {
		this.cheif = cheif;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getExcutors() {
		return excutors;
	}
	public void setExcutors(String excutors) {
		this.excutors = excutors;
	}
	public String getUploader() {
		return uploader;
	}
	public void setUploader(String uploader) {
		this.uploader = uploader;
	}
	public String getCampusDisplay() {
		return campusDisplay;
	}
	public void setCampusDisplay(String campusDisplay) {
		this.campusDisplay = campusDisplay;
	}
	public String getDepartmentDisplay() {
		return departmentDisplay;
	}
	public void setDepartmentDisplay(String departmentDisplay) {
		this.departmentDisplay = departmentDisplay;
	}
}