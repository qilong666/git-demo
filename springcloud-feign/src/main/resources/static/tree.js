$(function (){
    $.addtabs({iframeHeight:870});

    var tree = [
        {
            text:"中国新闻网",
            nodes: [
                {
                    text:"新闻中心",
                    nodes: [
                        {
                            text:"新闻信息",
                            url:"toShow"
                        },
                        {
                            text:"新闻Es实时搜索信息",
                            url:"toElastic"
                        },
                    ]
                },
            ]
        },

    ];
    $("#treeDiv").treeview({
        //data属性 树节点信息 json数组
        data: tree,
        //tree默认展开的节点级别默认为2
        levels: 0,
        //含有子节点的图标
        collapseIcon:'glyphicon glyphicon-star-empty',
        //没有子节点的图标
        emptyIcon:'glyphicon glyphicon-usd',
        //背景颜色
        //backColor: 'green'
        //是否显示复选框
        showCheckbox:true,
        //是否允许选中多个节点
        //multiSelect:true,
        //启用节点的超链接功能默认为false,节点需指定href属性
        enableLinks:false,
        //事件当节点选中时
        onNodeSelected:function(event,node){
            //动态向 nav-tabs 导航标签添加tab选项卡
            //addTabs方法  add() 添加tab  close()关闭tab  closeAll() 关闭全部tab
            if(null !=  node.url){
                $.addtabs.add({
                    id:node.id,
                    title:node.text,
                    url:node.url,
                })
            }

        }
    })
});
