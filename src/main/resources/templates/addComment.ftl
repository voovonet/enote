<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
</head>
<body>
	<div id="editor">
        
    </div>
    <div class="editorBar">
    	<button id="submitComment">保存</button><button>取消</button>
    </div>
<script src="/js/jquery-1.9.1.min.js"></script>
<script src="//unpkg.com/wangeditor/release/wangEditor.min.js"></script>
<script type="text/javascript">
	var E = window.wangEditor;
	var editor = new E('#editor');
	// 或者 var editor = new E( document.getElementById('editor') )
	editor.create();
	
	$("#submitComment").on("click",function saveComment(){
		var content=editor.txt.html();
		alert(content);
	});
</script>
</body>
</html>