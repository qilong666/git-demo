$(function (){
    $("#newsTab").bootstrapTable({
        url:"http://localhost:8082/findNewsList",
        method:"get",
        striped: true,  	// 斑马线效果     默认false
        //只允许选中一行
        singleSelect:false,
        //选中行是不选中复选框或者单选按钮
        clickToSelect:true,
        showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
        cardView: false,                    //是否显示详细视图
        uniqueId: "newId",                 //每一行的唯一标识，一般为主键列
        showColumns: true,                  //是否显示所有的列
        showRefresh: true,                  //是否显示刷新按钮
        minimumCountColumns: 2,     //  最少留两列
        detailView: false,                  //是否显示父子表
        //发送到服务器的数据编码类型
        contentType:'application/x-www-form-urlencoded;charset=UTF-8',   //数据编码纯文本  offset=0&limit=5
        toolbar:'#tabToolBar',   //  工具定义位置
        columns:[
            {field:'newId',title:"",width:100,
                formatter:function(value,row,index){   //  格式化  当前单元格内容
                    return "<input type='checkbox' value="+value+" name='chk'/>";
                }
            },
            /* {checkbox:true},*/
            {field:'newId',title:'序号',width:100},
            {field:'title',title:'标题',width:100},
            {field:'content',title:'内容',width:100},
            {field:'author',title:'作者',width:100},
            {field:'publishDate',title:'发布时间',width:100,
                /*formatter: function (value,row,index){
                    var simfomat = new Date();
                    simfomat.setTime(value);   //转换时间
                    return  simfomat.toLocaleDateString();
                }*/
            },
            {field:'typeName',title:'新闻类型',width:100},
            /* {field:'mOpenDate',title:'开卡时间',width:100,sortable:true
           formatter: function (value,row,index){
                  var simfomat = new Date();
                   simfomat.setTime(value);   //转换时间
                   return  simfomat.toLocaleDateString();
           } },*/
            {field:'crud',title:'操作',width:100,
                formatter: function (value,row,index){
                    var content =   '<button type="button"   class="btn btn-info"    onclick="updateNewsTable('+row.newId+')">修改</button>';
                    content +=  '<button type="button" class="btn btn-info"  onclick="deleteNewsTable('+row.newId+')">删除</button>';
                    return content;
                }
            }
        ],
        //传递参数（*）
        queryParams: function(params) {
            var whereParams = {
                /*
                    分页  自定义的参数         默认传 limit（展示几条）    offset（从第几条开始    起始条数）
                */
                "pageSize":params.limit,
                "start":params.offset,
                "title":params.search,//搜索产品名称
                "title":$("#title").val(),

            }
            return whereParams;
        },
        //前台--排序字段
        //sortName:'proPrice',
        //sortOrder:'desc',
        //前台--搜索框
        search:true,
        //启动回车键做搜索功能
        searchOnEnterKey:true,
        //分页方式   后台请求的分页方式
        sidePagination:'server',
        pagination:true,                   //是否显示分页（*）
        pageNum: 1,                       //每页的记录行数（*）
        pageSize: 5,                       //每页的记录行数（*）
        pageList: [5, 10, 15,20],        //可供选择的每页的行数（*）
    });


    queryAboutUs();

});

function  search(){
    $('#newsTab').bootstrapTable('refresh');
}


//全选
function  allcheck(){
    var all=document.getElementById("all").checked;
    var name=document.getElementsByName("chk");
    for(var i=0;i<name.length;i++){
        name[i].checked=all;
    }

}
//反选
function  fllcheck(){
    var name=document.getElementsByName("chk");
    for(var i=0;i<name.length;i++){
        name[i].checked =!name[i].checked;
    }

}



/*
  *发送ajax请求获取jsp页面内容
  */
function getJspHtml(urlStr){
    var  jspHtml = "";
    // async  (默认: true) 默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。
    //注意，同步请求将锁住浏览器，用户其它操作必须等待请求完成才可以执行。
    $.ajax({
        url:urlStr,
        type:'post',
        //同步的ajax
        async:false,
        success:function(data){
            //alert(data);//data--addProduct.jsp页面内容
            jspHtml = data;
        },
        error:function(){
            bootbox.alert("ajax失败");
        }
    });
    return jspHtml;
}

//修改 and 新增的 弹框
function  dialog(HTMLurl,submitUrl,title){
    var dialog = bootbox.dialog({
        title: title,
        message: getJspHtml(HTMLurl),   //调用方法
        buttons:{
            "save":{
                label: '保存',
                //自定义样式
                className: "btn-success",
                callback: function() {
                    $.ajax({
                        url:submitUrl,
                        type:'post',
                        data:$("#bootForm").serialize(),
                        success:function(data){
                            bootbox.alert("保存成功");
                            $("#newsTab").bootstrapTable('refresh');
                        },
                        error:function(){
                            bootbox.alert("ajax失败");
                        }
                    });
                }
            },
            "unSave":{
                label: '取消',
                //自定义样式
                className: "btn-info",
                callback: function() {
                    // return false;  //dialog不关闭
                }
            }
        }
    });
}

//新增 addTable
function addTable(){
    dialog("addNews","addNewsTable","新增");
}
//修改
function updateNewsTable(nId){
    dialog("findBootDialogById?id="+nId,"updateNews","修改");
}

//单条删除
function deleteNewsTable(nId){
    $.ajax({
        url :"deleteNews",
        type:"POST",
        data:{id:nId,_method:"DELETE"},
        success : function (){
            alert("删除成功");
            $("#newsTab").bootstrapTable('refresh');  //刷新
        },error : function (){
            alert("删除失败");
        }
    })
}


function queryAboutUs(){
    var form = $("#header_search").serialize();
    $.ajax({
        url:"http://localhost:8082/queryAllNews",
        type:'get',
        data:form,
        success:function(data){
            //alert(data[0].curriculumName);
            commonality(data.news);

            alert(data.loan[0].publishdate);
            $("#sum").html(data.npm.pageSum);
            $("#size").html(data.npm.pageSize);
            $("#now").val(data.npm.pageNow);
            $("#count").val(data.npm.pageCount);
        },
        error:function(){
            alert("失败");
        }
    });
}
//条查公用拼接代码  封装成了一个方法
function commonality(data){

    var carUi = "";
    for (var i = 0;i<data.length;i++){
        carUi +='  <div class="commodity">\n' +
            /*'        <img src="'+data[i].imgurl+'"/>\n' +*/
            '        <span class="s1">'+data[i].title+'</span><br />\n' +

            '        <span class="s2">'+data[i].content+'</span><br />\n' +

            '        <span class="s3">'+data[i].publishdate+'</span><br />\n' +
            '        <span class="s4">'+data[i].author+'</span><br />\n' +
            '        <p class="s5">'+data[i].typeid+'</p><br />\n' +
            '       <button type="button" class="btn btn-danger"  onclick="toInvestor('+data[i].id+')">查看详情</button>\n'+
            '     </div>';
    }
    $("#aboutUsData").html(carUi);
}