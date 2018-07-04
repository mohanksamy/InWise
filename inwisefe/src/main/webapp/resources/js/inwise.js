$(document).ready( function() {
	
	$('#sidenav ul ul').hide();
	$('#addnewpopwindow').hide(); 
	$('#searchpulldown').hide(); 
	$('#sidenav ul li a').click(function() {
		$(this).siblings('ul').slideToggle();
		if ($(this).is('.open')) {
			$(this).removeClass('open');
			$(this).addClass('closed');
		} else if ($(this).is('.closed')) {
			$(this).removeClass('closed');
			$(this).addClass('open');	
		}
	});
	
	$('#collapseallsidenav').hide();
	
	$('#expandallsidenav').click(function() {
		$('#sidenav ul li ul').slideDown(function() {
			$('#sidenav .closed').addClass('open');	
			$('#sidenav .closed').removeClass('closed');
		});
		$(this).hide();
		$('#collapseallsidenav').show();
	});
	
	$('#collapseallsidenav').click(function() {
		$('#sidenav ul li ul').slideUp(function() {
			$('#sidenav .open').addClass('closed');	
			$('#sidenav .open').removeClass('open');
		});
		$(this).hide();
		$('#expandallsidenav').show();
	});
	$('#hidesidenav').click(function() {
		$('body').removeClass('wnav').addClass('minnav');
		$('#leftside').hide();
		$('#leftsideminimized').show();
	});
	$('#expandsidebar a').click(function() {
		$('body').removeClass('minnav').addClass('wnav');
		$('#leftside').show();
		$('#leftsideminimized').hide();
	});

	$('.box .boxshowhide').click(function() {
		$(this).parents('.box').find('.boxcontent').slideToggle();
		if ($(this).is('.open')) {
			$(this).removeClass('open');
			$(this).addClass('closed');
			$(this + 'span').html('Expand');
		} else {
			$(this).removeClass('closed');
			$(this).addClass('open');
			$(this + 'span').html('Collapse');	
		}
	});
	
	$('.box .remove').click(function() {
		$(this).parents('.box').hide();
	});
	
	$('.maximizeall').click(function() {
		$('.boxcontent').slideDown();
		$('.box .boxshowhide').removeClass('closed').addClass('open');
		
	});
	
	$('.minimizeall').click(function() {
		$('.boxcontent').slideUp();
		$('.box .boxshowhide').removeClass('open').addClass('closed');
		
	});
	
	//content boxes, draggable - sorting...
	$("#maincontent #col1").sortable({
		opacity: 0.6, cursor: 'move', update: function() {
			//info here on how to record/save order... http://www.webresourcesdepot.com/dynamic-dragn-drop-with-jquery-and-php
		}
	});
	$("#maincontent #col2").sortable({
		opacity: 0.6, cursor: 'move', update: function() {
			//info here on how to record/save order... http://www.webresourcesdepot.com/dynamic-dragn-drop-with-jquery-and-php
		}
	});
	
	//homepage moveable boxes
	$("#home .colwrapper").sortable({
		opacity: 0.6, cursor: 'move', update: function() {
			//info here on how to record/save order... http://www.webresourcesdepot.com/dynamic-dragn-drop-with-jquery-and-php
		}
	});
	
	
	
	//table striping
	$("table.striped tr:nth-child(even)").addClass("altrow");

	$("table.datatable tr").hover(function() {
    	$(this).addClass("highlight");
   	},function()  {
    	$(this).removeClass("highlight");
   	});
	
	$(".datepicker").datepicker({ 
	            dateFormat: 'yy-mm-dd',
	            showButtonPanel: true,
	            changeMonth: true,
	            changeYear: true});
		
	//if (jQuery.isFunction(jQuery.calculator)) {
		//$(".calculator").calculator();
	//}

	var x = 0;
		if ( $.browser.msie ) {
		var version = parseInt( $.browser.version, 10 );
			if ( version > 7 ) {
			x = 21  ; 
			}
			else    { 
			x = 0 ;
			} 
		}
	var winwidth = (parseInt($(window).width())-x) ;   // returns width of browser viewport
	var docwidth = (parseInt($(document).width())-x) ;
	if (docwidth > winwidth) {
		$('#pageheader').width(docwidth);
	}
	else {
		$('#pageheader').width(winwidth);
	}	

});

function openNav(navid) {
	$(navid).slideDown();
	if ($(navid).is('.closed')) {
			$(navid).removeClass('closed');
			$(navid).addClass('open');	
		}	
}
function instantOpen(navid) {
	$(navid).show();
	if ($(navid).is('.closed')) {
			$(navid).removeClass('closed');
			$(navid).addClass('open');	
		}	
}

function initMenu() {
	$(section).show();
	
	$(page).removeClass('none');
	$(page).addClass('current');
}

function putcookie(c_name,value,expiredays) {
	var exdate=new Date();
  exdate.setDate(exdate.getDate()+expiredays);
  document.cookie = c_name + "=" + escape(value) + ((expiredays==null) ? "" : ";expires="+exdate);
}

function getcookie(c_name) {
	if(document.cookie.length > 0) {
		var c_start = document.cookie.indexOf(c_name + "=");
		if(c_start != -1) {
			c_start = c_start + c_name.length + 1;
			var c_end = document.cookie.indexOf(";",c_start);
			if(c_end == -1)
				c_end = document.cookie.length;
				return unescape(document.cookie.substring(c_start, c_end));
			}
	}
	return null;
}

function setTableAlternateRow() {    
    $("table.striped tr:nth-child(even)").addClass("altrow");
    $("table.datatable tr").hover(function() {
                    $(this).addClass("highlight");
    },function()  {
                    $(this).removeClass("highlight");
    });  
}
function setAlternateRowForNoHeader() {
    $("table.stripedForNoHeader tr:nth-child(odd)").addClass("altrow");
  $("table.datatable tr").hover(function() {
                  $(this).addClass("highlight");
  },function()  {
                  $(this).removeClass("highlight");
  });  
}
function pageheader_resize() 
	{
		var x = 0;
		if ( $.browser.msie ) {
		var version = parseInt( $.browser.version, 10 );
			if ( version > 7 ) {
			x = 21  ; 
			}
			else    { 
			x = 0 ;
			} 
		}
		var winwidth = (parseInt($(window).width())-x) ;   // returns width of browser viewport
		var docwidth = (parseInt($(document).width())-x) ;
		if (docwidth > winwidth) {
		$('#pageheader').width(docwidth);
		}
		else {
		$('#pageheader').width(winwidth);
		}	
	}
 $( window ).wresize( pageheader_resize );
 
 function setFloatHeadTable(floatHeaderTableId) {
	 $("#"+floatHeaderTableId).floatHeader();
	 setTableAlternateRow(); 
}
	
 var escapeContent = document.createElement('textarea');

 function escapeHTML(html) {
 	escapeContent.textContent = html;
     return escapeContent.innerHTML;
 }

 function unescapeHTML(html) {
 	escapeContent.innerHTML = html;
     return escapeContent.textContent;
 }