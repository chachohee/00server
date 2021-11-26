<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>


<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">My Music Info</h1>
  </div>
</div>


<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">

      <div class="panel-heading">Play List Read Page</div>
      <!-- /.panel-heading -->
      <div class="panel-body">

          <div class="form-group">
          <label>No</label> 
          <input class="form-control" name='pno'
            value='<c:out value="${playlist.pno }"/>' readonly="readonly">
        </div>

        <div class="form-group">
          <label>Play List Name</label> <input class="form-control" name='name'
            value='<c:out value="${playlist.name }"/>' readonly="readonly">
        </div>

<button data-oper='modify' class="btn btn-default">Modify</button>
<button data-oper='list' class="btn btn-info">Play List</button>


<form id='operForm' action="/music/modify" method="get">
  <input type='hidden' id='pno' name='pno' value='<c:out value="${playlist.pno}"/>'>
  <input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum}"/>'>
  <input type='hidden' name='amount' value='<c:out value="${cri.amount}"/>'>
  <input type='hidden' name='keyword' value='<c:out value="${cri.keyword}"/>'> 
</form>



      </div>
    </div>
  </div>
</div>



<div class='row'>
  <div class="col-lg-12">


    <div class="panel panel-default">
      <div class="panel-heading">
        <i class="fa fa-comments fa-fw"></i> Musics
        <button id='addMusicBtn' class='btn btn-primary btn-xs pull-right'>Add Music</button>
      </div>      
      
      
  
      <div class="panel-body">        
        <ul class="chat"> </ul>
      </div>
	
	<div class="panel-footer"></div>


		</div>
  </div>
</div>



<!-- Modal -->
      <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
        aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal"
                aria-hidden="true">&times;</button>
              <h4 class="modal-title" id="myModalLabel">MUSIC MODAL</h4>
            </div>
            <div class="modal-body">
              <div class="form-group">
                <label>Title</label> 
                <input class="form-control" name='title' value='New Music Title!!!!'>
              </div>      
              <div class="form-group">
                <label>Artist</label> 
                <input class="form-control" name='artist' value='Artist'>
              </div>
              <div class="form-group">
                <label>Music Link</label> 
                <input class="form-control" name='link' value='Music Link'>
              </div>   
              <div class="form-group">
                <label>Add Date</label> 
                <input class="form-control" name='addDate' value='2018-01-01 13:13'>
              </div>
      
            </div>
	<div class="modal-footer">
        <button id='modalModBtn' type="button" class="btn btn-warning">Modify</button>
        <button id='modalRemoveBtn' type="button" class="btn btn-danger">Remove</button>
        <button id='modalRegisterBtn' type="button" class="btn btn-primary">Register</button>
        <button id='modalCloseBtn' type="button" class="btn btn-default">Close</button>
      </div>          
     </div>
    <!-- /.modal-content -->
   </div>
   <!-- /.modal-dialog -->
</div>
<!-- /.modal -->



<script type="text/javascript" src="/resources/js/reply.js"></script>

<script>

$(document).ready(function () {
  
  var pnoValue = '<c:out value="${playlist.pno}"/>';
  var musicUL = $(".chat");
  
    showList(1);
    
function showList(page){
	
	  console.log("show list " + page);
    
    replyService.getList({bno:bnoValue,page: page|| 1 }, function(musicCnt, list) {
      
    console.log("musicCnt: "+ musicCnt );
    console.log("list: " + list);
    console.log(list);
    
    if(page == -1){
      pageNum = Math.ceil(musicCnt/10.0);
      showList(pageNum);
      return;
    }
      
     var str="";
     
     if(list == null || list.length == 0){
       return;
     }
     
     for (var i = 0, len = list.length || 0; i < len; i++) {
       str +="<li class='left clearfix' data-rno='"+list[i].mno+"'>";
       str +="  <div><div class='header'><strong class='primary-font'>["
    	   +list[i].mno+"] "+list[i].artist+"</strong>"; 
       str +="    <small class='pull-right text-muted'>"
           +musicService.displayTime(list[i].addDate)+"</small></div>";
       str +="    <p>"+list[i].title+"</p></div></li>";
     }
     
     musicUL.html(str);
     
     showMusicPage(musicCnt);

 
   });//end function
     
 }//end showList
    
    var pageNum = 1;
    var musicPageFooter = $(".panel-footer");
    
    function showMusicPage(musicCnt){
      
      var endNum = Math.ceil(pageNum / 10.0) * 10;  
      var startNum = endNum - 9; 
      
      var prev = startNum != 1;
      var next = false;
      
      if(endNum * 10 >= musicCnt){
        endNum = Math.ceil(musicCnt/10.0);
      }
      
      if(endNum * 10 < musicCnt){
        next = true;
      }
      
      var str = "<ul class='pagination pull-right'>";
      
      if(prev){
        str+= "<li class='page-item'><a class='page-link' href='"+(startNum -1)+"'>Previous</a></li>";
      }
      
      for(var i = startNum ; i <= endNum; i++){
        
        var active = pageNum == i? "active":"";
        
        str+= "<li class='page-item "+active+" '><a class='page-link' href='"+i+"'>"+i+"</a></li>";
      }
      
      if(next){
        str+= "<li class='page-item'><a class='page-link' href='"+(endNum + 1)+"'>Next</a></li>";
      }
      
      str += "</ul></div>";
      
      console.log(str);
      
      musicPageFooter.html(str);
    }
     
    musicPageFooter.on("click","li a", function(e){
       e.preventDefault();
       console.log("page click");
       
       var targetPageNum = $(this).attr("href");
       
       console.log("targetPageNum: " + targetPageNum);
       
       pageNum = targetPageNum;
       
       showList(pageNum);
     });     

   
    var modal = $(".modal");
    var modalInputTitle = modal.find("input[name='title']");
    var modalInputArtist = modal.find("input[name='artist]");
    var modalInputLink = modal.find("input[name='link]");
    var modalInputAddDate = modal.find("input[name='addDate']");
    
    var modalModBtn = $("#modalModBtn");
    var modalRemoveBtn = $("#modalRemoveBtn");
    var modalRegisterBtn = $("#modalRegisterBtn");
    
    $("#modalCloseBtn").on("click", function(e){
    	
    	modal.modal('hide');
    });
    
    $("#addMusicBtn").on("click", function(e){
      
      modal.find("input").val("");
      modalInputReplyDate.closest("div").hide();
      modal.find("button[id !='modalCloseBtn']").hide();
      
      modalRegisterBtn.show();
      
      $(".modal").modal("show");
      
    });
    

    modalRegisterBtn.on("click",function(e){
      
      var music = {
            Title:modalInputTitle.val(),
            Artist:modalInputArtist.val(),
            Link:modalInputLink.val(),
            pno:pnoValue
          };
      musicService.add(music, function(result){
        
        alert(result);
        
        modal.find("input").val("");
        modal.modal("hide");
        
        //showList(1);
        showList(-1);
        
      });
      
    });


  //댓글 조회 클릭 이벤트 처리 
    $(".chat").on("click", "li", function(e){
      
      var rno = $(this).data("mno");
      
      musicService.get(mno, function(music){
      
        modalInputTitle.val(music.title);
        modalInputArtist.val(music.artist);
        modalInputLink.val(music.link);
        modalInputAddDate.val(musicService.displayTime( music.addDate))
        .attr("readonly","readonly");
        modal.data("rno", reply.rno);
        
        modal.find("button[id !='modalCloseBtn']").hide();
        modalModBtn.show();
        modalRemoveBtn.show();
        
        $(".modal").modal("show");
            
      });
    });
  
    
    modalModBtn.on("click", function(e){
    	  
   	  var music = {mno:modal.data("mno"), music: modalInputTitle.val()};
   	  
   	  musicService.update(music, function(result){
   	        
   	    alert(result);
   	    modal.modal("hide");
   	    showList(pageNum);
   	    
   	  });
   	  
   	});


   	modalRemoveBtn.on("click", function (e){
   	  
   	  var mno = modal.data("mno");
   	  
   	  musicService.remove(rno, function(result){
   	        
   	      alert(result);
   	      modal.modal("hide");
   	      showList(pageNum);
   	      
   	  });
   	  
   	});

 
});

</script>

<script type="text/javascript">
$(document).ready(function() {
  
  var operForm = $("#operForm"); 
  
  $("button[data-oper='modify']").on("click", function(e){
    
    operForm.attr("action","/music/modify").submit();
    
  });
  
    
  $("button[data-oper='list']").on("click", function(e){
    
    operForm.find("#pno").remove();
    operForm.attr("action","/music/list")
    operForm.submit();
    
  });  
});
</script>


<%@include file="../includes/footer.jsp"%>
