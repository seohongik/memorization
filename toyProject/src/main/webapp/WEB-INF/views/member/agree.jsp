<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

    <link rel="stylesheet" type="text/css" href="${root}/resources/css/common.css">
    <link rel="stylesheet" type="text/css" href="${root}/resources/css/agree.css">
   	<script src="${root}/resources/js/jquery-3.1.1.min.js"></script>
    <script src="${root}/resources/js/jquery-ui.min.js"></script>
    <script src="${root}/resources/js/jquery.easing.1.3.js"></script>
    <script src="${root}/resources/js/jquery.mousewheel.min.js"></script>
 
 
 	<script>
     $(function(){

           
            var agreebox= $("input[type='checkbox']");
            
            var flag=false;

    
            
           
            
            
            //전체동의              
           $("#all-agree").click(function(){
                    var chk=$(this).is(":checked");
                    if(chk){
                        agreebox.prop('checked',true);
                        

                    }else{

                        agreebox.prop('checked',false);
                    }
  
                    
          });
            
            
          $("input[type='checkbox']").each(function(){
             

        	  $(this).click(function(){
        	  
        		if(agreebox.eq(0).is(":checked")==true && agreebox.eq(1).is(":checked")==true){
        		
        			$("#all-agree").prop("checked",true);
        		
        		
        		}else{
        			
        			$("#all-agree").prop("checked",false);
        			
        			 
        		
        		
        		}
        		
        	  })
            
             })
             
             
            //체크 여부 확인

            $("input[type='button']").click(function(){

            	if(agreebox.eq(0).is(":checked")==false ||agreebox.eq(1).is(":checked")==false){

                    alert("모두 동의하셔야 다음단계로 진행할 수 있습니다.");
                    return false;

            	}
                    
                    var service=$("input[name='service']").val();
                    var privacy=$("input[name='privacy']").val();

                	$.ajax({
                	    url:'/member/agreeParam', //request 보낼 서버의 경로
                	    type:'GET', // 메소드(get, post, put 등)
                	    dataType:"json",
                	    data:{
                	    	"service":service,
                	    	"privacy":privacy
                	     	
                	    }, 
                	    
                	    success: function(data) {
                	      
                	    	
                	    	console.log(data);
                	    	location.href="/member/showYourInfoBeforeJoin";
                	    	
                	    	
                	    },
                	    error: function(err) {
                	        //서버로부터 응답이 정상적으로 처리되지 못햇을 때 실행
                	    }
                	
                	});
            
         		
                	
            });



        });


        


    </script>
    
  <title>약관동의</title>
 
 
 
    
<%@ include file="/WEB-INF/views/include/header.jsp" %>    
      <nav>
            
                <h1>부가 서비스</h1>
                <ul id="member-tab">
                    <li ><a>로그인</a></li>
                    <li ><a>아이디*비밀번호찾기</a></li>
                    <li id="click-menu"><a>회원가입</a></li>
                    <li><a>개인정보처리방침</a></li>
                    <li><a>이용약관</a></li>
                    <li><a>이메일 무단수집 거부</a></li>
                    <li><a>영상정보처리기기 운영관리</a></li>
                </ul>


        </nav>
        <section >
        
            <h2>회원가입</h2>
            <p>아트센터 인천 회원가입 입니다.</p>
            <p>아직 비회원이신 분은 회원가입 및 로그인 후 공연예매 &amp; 대관 신청 및 다양한 서비스를 이용하실 수 있습니다.</p>
            <article class="agree-service">
               <img src="${root}/resources/images/end_step1.png">
            </article>
           
                
                <article class="agree-service">
                <h3>서비스 이용약관 (필수)</h3>
                
               
                <div class="service-using-frame">
                   <p>
                    제1조(목적)
                    이 약관은 아트센터 인천(이하 '아트센터'라고 한다.)에서 제공하는 웹사이트(이하 “서비스”라 한다)를 이용함에 있어 이용자와 아트센터 간의 권리ㆍ의무 및 책임사항과 기타 필요한 사항을 규정함을 목적으로 합니다.
                    
                    제 2 조(약관의 공지 및 개정)
                    1. 이 약관은 서비스 화면에 게시하여 공시 및 회원가입 서비스 화면에 게시하거나 기타의 방법으로 이용자에게 공지함으로써 효력을 발생합니다.
                    2. 이 약관에 동의하는 것을 조건으로 귀하에게 서비스를 제공할 것이며, 서비스 이용에는 이 약관이 우선적으로 적용될 것입니다.
                    3. 아트센터는 관련법을 위배하지 않는 범위에서 이 약관을 개정할 수 있으며, 약관을 개정할 경우에는 변경된 약관을 제 1항과 같은 방법으로 공지함으로써 효력을 발생합니다.
                    4. 이용자는 변경된 약관에 동의하지 않을 경우 서비스 이용을 중단하고 본인의 회원탈퇴(해지)를 요청할 수 있으며, 계속 사용하는 경우에는 약관 변경에 동의한 것으로 간주되며 약관은 전항과 같은 방법으로 효력을 발생합니다.
                    제 3 조(약관 외 준칙)
                    이용자가 이 약관의 내용에 동의하는 경우 아트센터의 서비스 제공행위 및 이용자의 서비스 이용행위에는 이 약관이 우선적으로 적용됩니다. 이 약관에 명시되지 않은 사항은 대한민국의 관계 법령에 규정되어 있을 경우 그 규정에 따르며, 그렇지 않은 경우에는 일반적인 관례에 따릅니다.
                    
                    제 4 조(용어의 정의)
                    이 약관에서 사용하는 용어의 정의는 다음과 같습니다.
                    
                    1. 이용자 : 서비스에 접속하여 아트센터가 제공하는 서비스를 받는 회원 및 비회원
                    2. 운영자 : 서비스의 전반적인 관리와 원활한 운영을 위하여 아트센터의 관장이 지정하여 당 사이트를 관리하는 자
                    3. 이용계약 : 서비스이용과 관련하여 아트센터와 이용자 간에 체결하는 계약
                    4. 가입 : 이 약관에 동의하며, 아트센터가 제공하는 신청서 양식에 해당 개인정보를 기록하고, 서비스 이용계약을 완료시키는 행위
                    5. 회원 : 아트센터와 이 약관에 정한 바에 따라서 “서비스” 이용계약을 체결하고 회원가입에 필요한 개인정보를 제공하여 회원가입을 한 자로서, 회원 아이디(ID)를 부여받은 자.
                    6. 회원 아이디(ID) : 회원 식별과 회원의 서비스 이용을 위하여 이용자가 선정하고 아트센터가 승인한 문자와 숫자의 조합
                    7. 비밀번호 : 회원 아이디(ID)와 일치된 회원임을 확인하는 번호로써, 회원의 정보 보호를 위해 회원 자신이 설정한 문자, 숫자 및 특수문자의 조합
                    8. 탈퇴(해지) : 아트센터 또는 회원이 “서비스” 이용계약 체결 후 이용계약의 효력을 상실시키는 행위
                    제 2 장 서비스 이용계약
                    제 5 조(이용계약의 성립)
                    1. 이용계약은 이용자가 본 이용약관 내용에 대한 동의와 이용신청에 대하여 아트센터의 이용승낙으로 성립합니다.
                    2. 당 사이트 이용약관의 동의는 "위의 이용약관에 동의하십니까?" 라는 이용신청시의 물음에 이용자가 "동의함" 단추를 누름으로써 약관에 동의하는 것으로 간주됩니다.
                    제 6 조(이용신청)
                    이용신청은 서비스의 회원가입 화면에서 이용자가 아트센터에서 요구하는 가입신청 양식에서 개인의 신상정보를 기록하여 신청합니다.
                    
                    제 7 조(이용신청의 승낙)
                    1. 아트센터는 이용자가 제6조에서 정한 모든 사항을 정확히 기재하여 이용신청을 하였을 경우 특별한 사정이 없는 한 서비스 이용신청을 승낙합니다.
                    2. 아트센터는 다음 각 호에 해당하는 경우 해당 사유가 해소될 때까지 이용계약 성립을 유보 및 일부 서비스 이용을 제한할 수 있습니다.
                    1) 서비스 관련 제반 용량이 부족한 경우
                    2) 기술상 장애 사유가 있는 경우
                    3) 기타 아트센터가 필요하다고 인정되는 경우
                    3. 아트센터는 다음 각 호에 해당하는 경우에는 이용신청을 제한하거나 회원가입을 취소할 수 있습니다.
                    1) 본인의 실명으로 신청하지 않은 경우
                    2) 다른 사람의 명의를 사용하여 신청한 경우
                    3) 회원가입 신청서의 내용을 허위로 기재하여 신청한 경우
                    4) 사회의 안녕 질서 또는 미풍양속을 저해할 목적으로 신청한 경우
                    5) 다른 사람의 서비스 이용을 방해하거나 그 정보를 도용하는 등의 행위를 한 경우
                    6) 서비스를 이용하여 관계법령과 이 약관이 금지하는 행위를 한 경우
                    7) 기타 아트센터가 정한 이용신청 요건이 미비 되었을 때
                    제 8 조(이용자ID 부여 및 계약사항의 변경)
                    1. 아트센터는 회원에 대하여 약관에 정하는 바에 따라 회원이 선정한 ID를 부여합니다.
                    2. 회원ID는 원칙적으로 변경이 불가하며, 변경 하고자 하는 경우에는 해당 ID를 해지하고 재가입해야 합니다.
                    3. 회원은 회원정보관리를 통해 언제든지 자신의 정보를 열람하고 수정할 수 있습니다. 회원은 이용신청 시 기재한 사항이 변경되었을 때에는 직접 수정을 하여야하며, 수정하지 아니하여 발생하는 문제의 책임은 회원에게 있습니다.
                    제 9 조(회원정보 사용에 대한 동의)
                    1. 회원의 개인정보에 대해서는 개인정보보호법 등 관련법령에 의하여 보호됩니다.
                    2. 아트센터는 회원가입 신청시 회원이 제공하는 정보를 통하여만 정보를 수집합니다.
                    3. 아트센터는 회원가입과 관련하여 수집된 개인정보를 본인의 승낙 없이 제3자에게 누설, 배포하지 않습니다. 단, 법률의 규정에 의해 국가기관의 요구가 있는 경우, 범죄에 대한 수사상의 목적이 있거나 방송통신위원회의 요청이 있는 경우 또는 기타 관계법령에서 정한 절차에 따른 요청이 있는 경우, 귀하가 당 사이트에 제공한 개인정보를 스스로 공개한 경우에는 그러하지 않습니다.
                    4. 회원이 당 사이트 약관에 따라 이용신청을 하는 것은 아트센터가 이 약관에 따라 신청서에 기재된 개인정보를 업무와 관련하여 회원전체 또는 일부의 통계자료를 작성하여 이를 사용할 수 있음을 의미합니다.
                    제 3 장 서비스 제공 및 이용
                    제 10 조 (서비스 이용)
                    1. 아트센터는 회원의 이용신청을 수락한 때부터 서비스를 개시합니다. 단, 일부 서비스의 경우에는 지정된 일자부터 서비스를 개시합니다.
                    2. 아트센터의 업무상 또는 기술상의 장애로 인하여 서비스를 개시하지 못하는 경우에는 사이트에 공시하거나 회원에게 이를 통지합니다.
                    3. 서비스의 이용은 연중무휴 1일 24시간을 원칙으로 합니다. 다만, 아트센터의 업무상 또는 기술상의 이유로 서비스가 일시 중지될 수 있고, 또한 정기점검 등 운영상의 목적으로 아트센터가 정한 기간에는 서비스가 일시 중지될 수 있습니다. 이러한 경우 아트센터는 사전 또는 사후에 이를 공지합니다.
                    4. 회원에 가입한 후라도 일부 서비스 이용 시 서비스 제공자의 요구에 따라 특정 회원에게만 서비스를 제공할 수도 있습니다.
                    5. 아트센터는 서비스를 일정범위로 분할하여 각 범위별로 이용가능 시간을 별도로 정할 수 있습니다. 이 경우 그 내용을 사전에 공지합니다.
                    제 11 조(서비스 제공의 중지)
                    1. 아트센터는 다음 각 호에 해당하는 경우 서비스 제공을 일시적으로 중지할 수 있습니다.
                    1) 서비스용 설비의 보수 등 공사로 인한 부득이한 경우
                    2) 전기통신사업법에 규정된 기간통신사업자가 전기통신 서비스를 중지했을 경우
                    3) 기타 불가항력적 사유가 있는 경우
                    2. 아트센터는 국가비상사태, 정전, 서비스 설비의 장애 또는 서비스 이용의 폭주 등으로 정상적인 서비스 이용에 지장이 있는 때에는 서비스의 전부 또는 일부를 제한하거나 중지할 수 있습니다.
                    3. 새로운 서비스로의 교체 등 아트센터가 적절하다고 판단하는 사유에 의하여 현재 제공하는 서비스를 완전히 중단할 수 있습니다.
                    4. 아트센터는 회원이 이 약관의 내용에 위배되는 행동을 한 경우 임의로 서비스 사용을 제한 및 중지하거나 귀하의 동의 없이 이용계약을 해지할 수 있습니다.
                    제 12 조(서비스 중지에 대한 공지 및 정보의 저장과 사용)
                    1. 이용자는 본 서비스에 보관되거나 전송된 메시지 및 기타 통신 메시지 등의 내용이 국가의 비상사태, 정전, 아트센터의 관리범위 외의 서비스 설비 장애 및 기타 불가항력에 의하여 보관되지 못하였거나 삭제된 경우, 전송되지 못한 경우 및 기타 통신 데이터의 손실에 대해 아트센터가 아무런 책임을 지지 않음에 동의합니다.
                    2. 아트센터가 정상적인 서비스 제공의 어려움으로 인하여 일시적으로 서비스를 중지하여야 할 경우에는 서비스 중지 1주일 전에 당 사이트를 통하여 공지한 후 서비스를 중지할 수 있으며, 이 기간 동안 이용자가 이 공지내용을 인지하지 못한데 대하여 아트센터는 책임을 부담하지 아니합니다. 부득이한 사정이 있을 경우 위 사전 공지기간은 감축되거나 생략될 수 있습니다.
                    3. 국가비상사태, 정전, 시스템관리자의 고의, 과실 없는 서비스 설비의 장애 또는 이용의 폭주 등 아트센터가 예측 및 통제할 수 없는 사유로 인한 서비스중단의 경우에 사전통지가 불가능하며, PC통신회사, 기간통신사업자 등 타인의 고의, 과실로 인한 시스템중단 등의 경우에는 통지하지 않습니다.
                    4. 위 2,3항의 서비스 중지에 의하여 본 서비스에 보관되거나 전송된 메시지 및 기타 통신 메시지 등의 내용이 보관되지 못하였거나 삭제된 경우, 전송되지 못한 경우 및 기타 통신 데이터의 손실이 있을 경우에 대하여도 아트센터는 책임을 부담하지 아니합니다.
                    5. 아트센터의 사정으로 서비스를 영구적으로 중단하여야 할 경우 제2항을 준용합니다. 다만, 이 경우 사전 고지기간은 1개월 이상으로 합니다.
                    6. 아트센터는 사전 고지 후 서비스를 일시적으로 수정, 변경 및 중단할 수 있으며, 이에 대하여 회원 또는 제3자에게 어떠한 책임도 부담하지 아니합니다.
                    7. 아트센터는 회원이 이 약관의 내용에 위배되는 행동을 한 경우, 임의로 서비스 사용을 중지할 수 있습니다. 이 경우 아트센터는 회원의 접속을 금지할 수 있으며, 회원이 게시한 내용의 전부 또는 일부를 임의로 삭제할 수 있습니다.
                    8. 장기간 휴면 회원인 경우 안내 메일 또는 공지사항 발표 후 1주일간의 통지 기간을 거쳐 서비스 사용을 중지할 수 있습니다.
                    제 13 조 (정보의 제공)
                    1. 아트센터는 회원이 서비스 이용 중 필요가 있다고 인정되는 다양한 정보에 대해서 사이트에 게재하거나 전자우편, 휴대폰 문자발송 등의 방법으로 회원에게 제공할 수 있습니다.
                    2. 회원은 정보제공을 원치 않을 경우 개인정보관리 메뉴에서 정보수신거부를 할 수 있습니다.
                    제 14 조(회원의 게시물 및 삭제)
                    1. 귀하가 게시한 게시물의 내용에 대한 권리는 귀하에게 있습니다.
                    2. 아트센터는 회원이 게시하거나 등록하는 서비스 내의 모든 내용물이 다음 각 호의 경우에 해당된다고 판단되는 경우 사전 통지 없이 삭제할 수 있으며, 이에 대해 아트센터는 어떠한 책임도 지지 않습니다.
                    1) 국가안전이나 보안에 위배되는 경우
                    2) 정치적 목적이나 성향이 있는 경우
                    3) 특정기관, 단체, 부서를 근거 없이 비난하는 경우
                    4) 특정인을 비방하거나 명예훼손의 우려가 있는 경우
                    5) 영리목적의 상업성 광고, 저작권을 침해할 수 있는 내용
                    6) 욕설, 음란물 등 불건전한 내용
                    7) 실명을 원칙으로 하는 경우에 실명을 사용하지 않은 경우
                    8) 동일인이라고 인정되는 자가 동일 또는 유사내용을 반복하여 게재하는 도배성 글
                    9) 연습성, 오류, 장난성의 글
                    10) 기타 해당 게시판의 취지와 부합하지 않을 경우 등
                    11) 기타 관계법령에 위반된다고 판단되는 경우
                    3. 귀하의 게시물이 타인의 저작권을 침해함으로써 발생하는 민, 형사상의 책임은 전적으로 귀하가 부담하여야 합니다.
                    4. 아트센터는 게시된 내용이 일정기간 이상 경과되어, 게시물로써의 효력을 상실하여 그 존치 목적이 불분명한 경우 공지사항 발표 후 1주일간의 통지기간을 거쳐 해당 게시물을 삭제할 수 있습니다.
                    제 15 조(게시물의 저작권)
                    1. 게시물에 대한 권리와 책임은 게시자에게 있으며 아트센터는 게시자의 동의 없이는 이를 서비스내 게재 이외에 영리목적으로 사용할 수 없습니다. 단, 비영리적인 경우에는 그러하지 아니하며 또한 아트센터는 서비스내의 게재권을 갖습니다.
                    2. 회원은 서비스를 이용하여 얻은 정보를 복사, 가공, 번역, 2차적 저작 등을 하여 복제, 공연, 방송, 전시, 배포, 출판 등에 사용하거나 제 3자에게 제공하는 행위를 할 수 없습니다.
                    3. 회원의 게시물이 타인의 저작권, 프로그램 저작권 등을 침해함으로써 발생하는 민, 형사상의 책임은 전적으로 회원이 부담하여야 합니다.
                    4. 회원은 서비스를 이용하여 얻은 정보를 가공, 판매하는 행위 등 서비스에 게재된 자료를 상업적으로 사용할 수 없습니다.
                    제 16 조 (아트센터의 소유권)
                    1. 아트센터가 제공하는 서비스, 그에 필요한 소프트웨어, 이미지, 마크, 로고, 디자인, 서비스명칭, 정보 및 상표 등과 관련된 지적재산권 및 기타권리는 아트센터에게 소유권이 있습니다.
                    2. 회원은 아트센터가 명시적으로 승인한 경우를 제외하고는 제1항 소정의 각 재산에 대한 전부 또는 일부의 수정, 대여, 대출, 판매, 배포, 제작, 양도, 재라이선스, 담보권 설정행위, 상업적 이용행위를 할 수 없으며, 제3자로 하여금 이와 같은 행위를 하도록 허락할 수 없습니다.
                    제 4 장 계약당사자의 의무
                    제 17 조(아트센터의 의무)
                    1. 아트센터는 특별한 사정이 없는 한 회원이 신청한 서비스 제공 개시일에 서비스를 이용할 수 있도록 합니다.
                    2. 아트센터는 이 약관에서 정한 바에 따라 계속적, 안정적으로 서비스를 제공할 의무가 있습니다.
                    3. 아트센터는 회원으로부터 제기되는 의견이나 불만이 정당하다고 인정할 경우에는 신속히 처리하여야 합니다. 다만, 신속한 처리가 곤란한 경우에는 회원에게 그 사유와 처리일정을 통보하여야 합니다.
                    4. 아트센터는 관련법령이 정하는 바에 따라서 회원 등록정보를 포함한 회원의 개인정보를 보호하기 위하여 노력합니다. 회원의 개인정보보호에 관해서는 관련법령 및 제 20조에 제시된 내용을 지킵니다.
                    제 18 조(회원의 의무)
                    1.회원은 서비스 이용을 위해 가입할 경우 현재의 사실과 일치하는 완전한 정보(이하 "가입정보"라 한다)를 제공하여야 합니다. 또한 가입정보에 변경이 발생할 경우 즉시 갱신하여야 합니다.
                    2. 회원이 서비스 사용을 위한 가입절차를 완료하시면 아이디와 비밀 번호를 받게 되며 자신의 아이디(ID) 및 비밀번호를 제3자가 이용하게 해서는 안됩니다.
                    3. 회원은 당 사이트의 서비스를 이용하여 얻은 정보를 아트센터의 사전 승낙 없이 복사, 복제, 변경, 번역, 출판, 방송 기타의 방법으로 사용하거나 이를 타인에게 제공할 수 없습니다.
                    4. 회원은 아트센터의 사전승낙 없이는 서비스를 이용하여 어떠한 영리행위도 할 수 없습니다. 회원의 영리행위로 인한 결과에 대하여 관장은 어떠한 책임도 지지 않으며, 회원은 영리행위에 대하여 관장에게 손해배상의무를 집니다.
                    5. 회원은 이 약관에서 규정하는 사항과 내용별 서비스 이용안내 또는 주의사항을 준수하여야 합니다.
                    6. 회원은 서비스의 이용권한 기타 이용계약상 지위를 타인에게 양도, 증여할 수 없으며, 이를 담보로 제공할 수 없습니다.
                    7. 회원은 당 사이트 서비스 이용과 관련하여 다음 각호의 행위를 하지 않기로 동의합니다.
                    1) 타인(소수를 포함)에게 위해를 가하는 행위
                    가. 타인의 ID, PASSWORD, 주민등록번호 도용 및 타인으로 가장하는 행위
                    나. 타인과의 관계를 허위로 명시하는 행위
                    다. 타인을 비방할 목적으로 사실 또는 허위의 사실을 적시하여 명예를 훼손하는 행위
                    라. 자기 또는 타인에게 재산상의 이익을 주거나 타인에게 손해를 가할 목적으로 허위의 정보를 유통시키는 행위
                    마. 수치심이나 혐오감 또는 공포심을 일으키는 말이나 음향, 글이나 화상 또는 영상을 계속하여 상대방에게 도달하게 하여 상대방의 일상적 생활을방해하는 행위
                    바. 아트센터의 사전 승낙 없이 서비스를 이용한 영리행위
                    사. 타인의 정보통신서비스 이용명의를 도용하여 사용하는 행위
                    
                    2) 불필요하거나 승인되지 않은 광고, 판촉물을 게재하거나, "정크 메일(junk mail)", "스팸(spam)", "행운의 편지(chain letters)", "도배글", "피라미드 조직" 등을 권유하거나 게시, 게재 또는 전자우편으로 보내는 행위
                    3) 저속, 음란, 모욕적, 위협적이거나 타인의 사생활을 침해할 수 있는 내용을 전송, 게시, 게재 또는 전자우편등 기타의 방법으로 전송하는 행위
                    4) 서비스를 통하여 전송된 내용의 출처를 위장하는 행위
                    5) 법률, 계약에 의해 이용할 수 없는 내용을 게시, 게재 또는 전자우편 등 기타의 방법으로 전송하는 행위
                    6) 타인의 특허, 상표, 영업비밀, 저작권, 기타 지적재산권을 침해하는 내용을 게시, 게재 또는 전자우편 등 기타의 방법으로 전송하는 행위
                    7) 다른 이용자의 개인정보의 수집 또는 저장하는 행위
                    8) 범죄행위를 목적으로 하거나 기타 범죄행위와 관련된 행위
                    9) 선량한 풍속, 기타 사회질서를 해하는 행위
                    10) 타인의 명예를 훼손하거나 모욕하는 행위
                    11) 해킹행위 또는 컴퓨터바이러스의 유포행위
                    다른 컴퓨터 코드, 파일, 프로그램을 포함하고 있는 자료를 게시, 게재, 전자우편으로 보내는 행위 등 다른 사용자의 개인정보를 수집 또는 저장하는 행위
                    12) 타인의 의사에 반하여 광고성 정보 등 일정한 내용을 지속적으로 전송하는 행위
                    13) 서비스의 안정적인 운영에 지장을 주거나 줄 우려가 있는 일체의 행위
                    14) 재물을 걸고 도박하거나 사행행위를 하는 행위
                    15) 윤락행위를 알선하거나 음행을 매개하는 내용의 정보를 유통시키는 행위
                    16) 기타 불법적이거나 부당한 행위
                    8. 회원은 이 약관 및 관계법령에서 규정한 사항을 준수하여야 합니다.
                    제 19 조(회원 아이디와 비밀번호 관리에 대한 회원의 의무)
                    1. 이용자는 회원가입을 완료하는 순간부터 입력한 정보의 비밀을 유지할 책임이 있으며, 아이디(ID)와 비밀번호를 사용하여 발생하는 모든 결과에 대한 책임은 회원에게 있습니다.
                    2. 아이디(ID)와 비밀번호에 관한 모든 관리책임은 회원에게 있으며, 회원의 개인정보보호 및 관리를 위하여 서비스의 개인정보관리에서 수시로 본인의 개인정보를 수정/삭제할 수 있습니다. 수신되는 선택정보 중 불필요하다고 생각되는 부분은 변경/조정할 수 있습니다.
                    3. 회원의 개인정보는 오직 본인만이 열람/수정/삭제할 수 있으며, 이는 전적으로 귀하의 아이디(ID)와 비밀번호에 의해 관리되고 있습니다. 따라서 타인에게 회원의 아이디(ID)와 비밀번호를 알려주어서는 아니 되며, 서비스의 사용 종료 시마다 정확히 logout 해야 하며, logout 하지 아니하여 제3자가 귀하에 관한 정보를 도용하여 발생하는 결과로 인해 발생하는 손해 및 손실에 대하여 아트센터는 책임을 부담하지 아니합니다.
                    4. 회원에게 부여된 아이디(ID)와 비밀번호의 관리소홀, 부정사용에 의하여 발생하는 모든 결과에 대한 책임은 회원에게 있으며, 자신의 아이디가 부정하게 사용된 경우 회원은 반드시 아트센터에 그 사실을 통보해야 하며, 신고를 하지 않음으로 인해 발생하는 모든 책임은 회원 본인에게 있습니다.
                    제 20 조 (개인정보보호정책)
                    1. 아트센터는 이용 신청 시 회원이 제공하는 정보를 통하여 회원에 관한 정보를 수집하며, 회원의 개인정보는 본 이용계약의 이행과 본 이용계약상의 서비스 제공을 위한 목적으로 이용합니다.
                    2. 아트센터는 서비스 제공과 관련하여 취득한 회원의 정보를 본인의 승낙 없이 제3자에게 누설 또는 배포할 수 없으며 상업적 목적으로 사용할 수 없습니다. 다만, 다음의 각 호의 경우에는 그러하지 아니합니다.
                    가.관계 법령에 의하여 수사상의 목적으로 관계기관으로부터 요구가 있는 경우
                    나.방송통신심의위원회의 요청이 있는 경우
                    다.기타 관계법령에서 정한 절차에 따른 요청이 있는 경우
                    3. 아트센터는 회원의 개인정보를 2년을 주기로 회원의 재동의 절차를 거쳐 동의한 경우에 한하여 계속적으로 보유하며, 재동의 하지 않은 회원의 개인정보는 휴면계정으로 관리 후 일정기간이 지난 후 파기합니다.
                    제 5 장 계약해지 및 이용제한
                    제 21 조 (계약해지 및 이용제한)
                    1. 회원이 이용계약을 해지하고자 하는 때에는 회원 본인이 온라인을 통해 당 사이트에 해지 신청을 하여야 합니다.
                    2. 아트센터는 보안 및 아이디 정책, 서비스의 원활한 제공 등과 같은 이유로 회원의 ID 및 PASSWORD 변경을 요구하거나 변경 할 수 있습니다.
                    3. 아트센터는 회원이 다음 각 호의 1에 해당하는 행위를 하였을 경우 사전통지 없이 이용계약을 해지하거나 또는 기간을 정하여 서비스 이용을 중지할 수 있으며, 이로 인해 발생하는 불이익에 대해 책임을 부담하지 아니합니다.
                    1) 타인의 이용자ID 및 비밀번호를 도용한 경우
                    2) 서비스 운영을 고의로 방해한 경우
                    3) 가입한 이름이 실명이 아닌 경우
                    4) 같은 이용자가 다른 ID로 이중등록을 한 경우
                    5) 범죄적 행위에 관련되는 경우
                    6) 공공질서 및 미풍양속에 저해되는 내용을 고의로 유포시킨 경우
                    7) 국익 또는 사회적 공익을 저해할 목적으로 서비스이용을 계획 또는 실행하는 경우
                    8) 타인의 명예를 손상시키거나 불이익을 주는 행위를 한 경우
                    9) 서비스의 안정적 운영을 방해할 목적으로 다량의 정보를 전송하거나 광고성 정보를 전송하는 경우
                    10) 정보통신설비의 오작동이나 정보 등의 파괴를 유발시키는 컴퓨터 바이러스 프로그램 등을 유포하는 경우
                    11) 아트센터, 다른 회원 또는 제3자의 지적재산권을 침해하는 경우
                    12) 방송통신심의위원회 등 외부기관의 시정요구가 있거나 불법선거운동과 관련하여 선거관리위원회의 유권해석을 받은 경우
                    13) 아트센터의 사전 승낙 없이 서비스 정보를 이용하여 얻은 정보를 복제 또는 유통시키거나 상업적으로 이용하는 경우
                    14) 회원이 자신의 홈페이지와 게시판에 음란물을 게재하거나 음란사이트를 링크하는 경우
                    15) 기타 관련법령이나 아트센터가 정한 이용조건에 위배되는 경우
                    제 6 장 손해배상 등
                    제 22 조 (소유권)
                    1. 당 사이트가 제공하는 서비스, 그에 필요한 소프트웨어, 이미지, 마크, 로고, 디자인, 서비스명칭, 정보 및 상표 등과 관련된 지적재산권 및 기타 권리는 아트센터에 소유권이 있습니다.
                    2. 귀하는 1항에 대한 전부 또는 일부의 수정, 대여, 대출, 판매, 배포, 제작, 양도, 재 라이선스, 담보권 설정 행위, 상업적 이용 행위를 할 수 없으며, 제3자로 하여금 이와 같은 행위를 하도록 허락할 수 없습니다.
                    제 23 조 (손해배상)
                    아트센터는 서비스 요금이 무료인 동안의 서비스 이용과 관련하여 회원에게 발생한 어떠한 손해에 관하여도 책임을 지지 않습니다.
                    
                    제 24 조 (면책조항)
                    1. 아트센터는 천재지변 또는 이에 준하는 불가항력으로 인하여 서비스를 제공할 수 없는 경우에는 서비스 제공에 관한 책임이 면제됩니다.
                    2. 아트센터는 기간통신 사업자가 전기통신 서비스를 중지하거나 정상적으로 제공하지 아니하여 손해가 발생한 경우 책임을 지지 않습니다.
                    3. 아트센터는 긴급한 시스템 점검, 증설 및 교체, 보수, 공사 등 부득이한 사유로 발생한 서비스 중단으로 발생한 손해에 대한 책임을 지지 않습니다.
                    4. 아트센터는 회원의 귀책사유로 인한 서비스 이용의 장애에 대하여 책임을 지지 않습니다.
                    5. 아트센터는 회원이 서비스를 이용하여 기대하는 수익을 상실한 것에 대하여 책임을 지지 않으며 그밖에 서비스를 통하여 얻은 자료로 인한 손해에 관하여 책임을 지지 않습니다.
                    6. 아트센터는 회원이 서비스에 게재한 정보, 자료, 사실의 신뢰도, 정확성 등 내용에 관하여는 책임을 지지 않습니다.
                    7. 아트센터는 회원간 또는 회원과 제3자간에 서비스를 매개로 하여 물품거래 혹은 금전적 거래 등과 관련하여 어떠한 책임도 지지 않으며, 이용자가 서비스를 이용하며 타 이용자로 인해 입게 되는 정신적 피해에 대하여 보상할 책임을 지지 않습니다.
                    8. 아트센터는 당 사이트가 제공한 서비스가 아닌 가입자 또는 기타 유관기관이 제공하는 서비스의 내용상의 정확성, 완전성 및 질에 대하여 보장하지 않으며, 귀하가 위 내용을 이용함으로 인하여 입게 된 모든 종류의 손실이나 손해에 대하여 책임을 부담하지 아니합니다.
                    제 7 장 기타
                    제 25 조(전자우편주소의 수집ㆍ매매 등 금지)
                    1. 회원은 전자우편주소 추출기 등을 이용하여 회원의 전자우편주소를 수집 또는 제3자에게 매매ㆍ제공할 수 없습니다.
                    2. 전자우편주소 추출기 또는 전자우편주소 생성기 등을 이용하여 회원에게 무작위로 전송되는 전자우편을 차단할 수 있으며, 이러한 조치로 인하여 당해 전자우편을 수신하지 못한 것에 대하여 책임지지 않습니다.
                    3. 회원이 제1항 및 제2항의 규정을 위반하여 타 회원에게 정신적ㆍ물질적 손해를 끼친 경우에는 민사 또는 형사소송을 제기하여 그 손해에 대한 책임을 물을 수 있습니다.
                    제 26 조 (책임)
                    1. 아트센터는 서비스 이용과 관련하여 아트센터의 고의 또는 중과실이 없는 한 회원에게 발생한 어떠한 손해에 대해서도 책임을 지지 않습니다. 아트센터는 서비스 이용과 관련한 정보, 제품, 서비스, 소프트웨어, 그래픽, 음성, 동영상의 적합성, 정확성, 시의성, 신빙성에 관한 보증 또는 담보책임을 부담하지 않습니다.
                    2. 아트센터는 회원들의 게시물을 pre-screening 하지 아니하고, 상시적으로 게시물의 내용을 확인하거나 검토하지 아니하며, 이에 대한 의무나 그 결과에 대한 책임을 지지 아니합니다.
                    3. 아트센터는 이용자의 컴퓨터 오류에 의해 손해가 발생한 경우, 또는 회원이 신상정보 및 전자우편 주소를 부실하게 기재하여 손해가 발생한 경우 책임을 지지 않습니다.
                    4. 아트센터는 회원이 서비스를 이용하여 기대하는 수익을 얻지 못하거나 상실한 것에 대하여 책임을 지지 않습니다.
                    5. 아트센터는 회원이 서비스를 이용하면서 얻은 자료로 인한 손해에 대하여 책임을 지지 않습니다. 또한 아트센터는 회원이 서비스를 이용하며 타 회원으로 인해 입게 되는 정신적 피해에 대하여 보상할 책임을 지지 않습니다.
                    6. 아트센터는 회원이 서비스에 게재한 각종 정보, 자료, 사실의 신뢰도, 정확성 등 내용에 대하여 책임을 지지 않습니다.
                    7. 아트센터는 이용자 상호간 및 이용자와 제 3자 상호 간에 서비스를 매개로 발생한 분쟁에 대해 개입할 의무가 없으며, 이로 인한 손해를 배상할 책임도 없습니다.
                    8. 아트센터에서 회원에게 무료로 제공하는 서비스의 이용과 관련해서는 어떠한 손해도 책임을 지지 않습니다.
                    제 27 조 (관할법원)
                    1. 서비스 이용과 관련하여 아트센터와 회원 사이에 분쟁이 발생한 경우, 아트센터와 회원은 발생한 분쟁을 원만하게 해결하기 위하여 필요한 모든 노력을 하여야 합니다
                    2. 제1항의 규정에도 불구하고 서비스 이용으로 발생한 분쟁에 대하여 소송이 제기될 경우 아트센터 소재지를 관할하는 법원을 관할법원으로 합니다.
                    부칙
                    (시행일) 이 약관은 2018년 11월 16일부터 시행합니다.
                   
                </p>
                  
                </div>
                
             
            </article>
            <input type="checkbox" id="service" name="service" value='Y'><label for="service">서비스 이용약관에 동의합니다.</label>
        
            <article class="agree-service">
                <h3>서비스 이용약관 (필수)</h3>
                
               
                <div class="service-using-frame">
                   <p>
                    '아트센터 인천'은 (이하 '아트센터'라고 한다.) 이용자의 개인정보를 중요시하며, "개인정보보호법및 정보통신망 이용촉진 및 정보보호"에 관한 법률을 준수하고 있습니다.
                    모든 개인정보는 관련법령에 근거하거나 정보주체의 동의에 의하여 수집 보유 및 처리되고 있습니다.
                    「개인정보 보호법」은 이러한 개인정보의 취급에 대한 일반적 규범을 제시하고 있으며, 아트센터는 이러한 법령의 규정에 따라 수집 · 보유 및 처리하는 개인정보를 공공업무의 적절한 수행과 회원을 보호하기 위해 적법하고 적정하게 취급할 것입니다.
                    아트센터는 개인정보처리방침을 통하여 이용자가 제공하는 개인정보가 어떠한 용도와 방식으로 이용되고 있으며, 개인정보 보호를 위해 어떠한 조치가 취해지고 있는지 알려드립니다.
                    또한, 관련 법령에서 규정한 바에 따라 아트센터에서 보유하고 있는 개인정보에 대한 열람청구권 및 정정 청구권 등 여러분의 권익을 존중하며, 여러분은 이러한 법령상 권익의 침해 등에 대하여 행정심판법에서 정하는 바에 따라 행정심판을 청구할 수 있습니다.
                    만일 개인정보처리방침을 개정하는 경우에는 웹사이트 공지사항(또는 개별공지)을 통하여 안내해 드립니다.
                    
                    제1조(개인정보의 처리목적)
                    1. 아트센터는 다음의 목적을 위하여 개인정보를 처리합니다. 처리하고 있는 개인정보는 다음의 목적 이외의 용도로는 이용되지 않으며, 이용 목적이 변경되는 경우에는 개인정보보호법 제18조에 따라 별도의 동의를 받는 등 필요한 조치를 이행할 예정입니다.
                    
                    가. 홈페이지 회원 가입 및 관리
                    회원 가입의사 확인, 회원제 서비스 제공에 따른 본인 식별·인증, 회원자격 유지·관리, 제한적 본인확인제 시행에 따른 본인확인, 서비스 부정이용 방지, 만 14세 미만 아동의 개인정보 처리시 법정대리인의 동의여부 확인, 각종 고지·통지 등을 목적으로 개인정보를 처리합니다.
                    
                    나. 민원사무 처리
                    민원인의 신원 확인, 민원사항 확인, 사실조사를 위한 연락·통지, 처리결과 통보 등의 목적으로 개인정보를 처리합니다.
                    
                    다. 재화 또는 서비스 제공
                    공연, 예매(발권) 서비스 제공, 콘텐츠 제공, 본인인증, 요금결제·정산 등을 목적으로 개인정보를 처리 합니다.
                    
                    아트센터에서 개인정보 보호법 제32조에 따라 등록·공개하는 개인정보파일의 처리목적은 다음과 같습니다.
                    
                    순번	개인정보파일의 명칭	처리목적	개인정보파일에 기록되는 개인정보의 항목
                    1	아트센터 인천 회원제	회원 컨텐츠 이용
                    공연 예매(발권) 서비스 이용
                    마케팅, 프로모션	ID, 이름, 비밀번호, 생년월일, 성별, 지역(시·도), 이메일, 휴대폰번호, 정보메일수신여부, 정보SMS수신여부, (개인정보 항목중 이름, 생년월일, 성별, 휴대폰 번호는 회원 가입을 위한 본인 인증 후 NICE 신용정보평가(주)에서 제공)
                    2	대관신청단체	온라인 공연 대관 신청, 검인업무	ID, 비밀번호, 회사명, 대표자성명, 휴대폰번호, 이메일, 팩스번호, 생년월일 사업자등록번호
                    제2조(개인정보의 처리 및 보유기간)
                    1. 아트센터는 법령에 따른 개인정보 보유·이용기간 또는 정보주체로부터 개인정보를 수집시에 동의받은 개인정보 보유·이용기간 내에서 개인정보를 처리·보유합니다.
                    
                    2. 각각의 개인정보 처리 및 보유 기간은 다음과 같습니다.
                    
                    순번	개인정보파일의 명칭	수집이용·근거	보유기간
                    1	아트센터 인천 회원제	정보 주체 동의 (회원가입시)	탈퇴시까지
                    2	대관신청단체	정보 주체 동의 (신청시)	5년
                    다만, 다음의 사유에 해당하는 경우에는 해당 사유 종료시까지
                    
                    1) 관계 법령 위반에 따른 수사·조사 등이 진행중인 경우에는 해당 수사·조사 종료시 까지
                    2) 홈페이지 이용에 따른 채권·채무관계 잔존시에는 해당 채권·채무관계 정산시까지
                    
                    기타관련법령:
                    계약 또는 청약철회 등에 관한 기록 : 5년 (전자상거래등에서의 소비자보호에 관한 법률)
                    대금결제 및 재화 등의 공급에 관한 기록 : 5년 (전자상거래등에서의 소비자보호에 관한 법률)
                    
                    제3조(개인정보의 제3자 제공)
                    1. 아트센터는 정보주체의 동의, 법률의 특별한 규정 등 개인정보보호법 제17조 및 제18조에 해당하는 경우에만 개인정보를 제3자에게 제공합니다.
                    
                    2. 아트센터는 다음과 같이 개인정보를 제3자에게 제공하고 있습니다.
                    실명확인 및 I-PIN 인증시 제공하는 개인정보는 개인정보보호법 제22조제2항에 따라 정보주체와의 계약체결을 위하여 정보주체의 동의 없이 처리할 수 있는 개인정보로 지정합니다.
                    본인확인 서비스중 실명인증시 입력하는 정보는 공인된 기관과 실명인증용도로 사용되며 아트센터는 위와 같은 고유 식별정보를 별도 저장하지 않습니다.
                    
                    가. 실명확인 및 본인인증
                    · 개인정보를 제공받는 자 : NICE신용평가정보(주)
                    · 제공받는 자의 개인정보 이용목적 : 실명확인 및 본인인증
                    · 제공하는 개인정보 항목 : 이름, 성별, 생년월일, 핸드폰 번호
                    · 제공받는 자의 보유·이용기간 : 본인확인용도의 개인정보이고 별도로 저장하지 않음
                    
                    나. 나이스 I-PIN 인증
                    · 개인정보를 제공받는 자 : NICE신용평가정보(주)
                    · 제공받는 자의 개인정보 이용목적 : 본인 인증
                    · 제공하는 개인정보 항목 : I-PIN(개인식별번호)
                    · 제공받는 자의 보유·이용기간 : 본인확인용도의 개인정보이고 별도로 저장하지 않음
                    
                    제4조(개인정보처리의 위탁)
                   
                </p>
                  
                </div>

                
             
            </article>
            <input type="checkbox" id="privacy" name="privacy" value="Y" ><label for="privacy">개인정보 수집 및 취급방침에 동의합니다.</label>
        
        
        
            <article>
                <div id="btns-wrap">
                    <input type="checkbox" id="all-agree" name="all-agree"><label for="all-agree">아트센터 인천의 전체 동의합니다.</label>
                    <br>
                    <input type="reset"  class="agree-btns" value="취소">
                    <input type="button" class="agree-btns" value="확인">
                    
                </div>
            </article>
        
        
      
        </section>

    </div>
    <!--//콘텐츠-->

    
<%@ include file="/WEB-INF/views/include/footer.jsp" %>

 