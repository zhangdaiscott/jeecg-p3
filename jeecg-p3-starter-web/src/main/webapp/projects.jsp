<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>JEECG-P3 微服务插件开发框架</title>
    <meta name="keywords" content="JEECG-P3 微服务，插件开发框架">
    <meta name="description" content="JEECG-P3 微服务，插件开发框架">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="plug-in-ui/hplus/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="plug-in-ui/hplus/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="plug-in-ui/hplus/css/animate.css" rel="stylesheet">
    <link href="plug-in-ui/hplus/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">

    <div class="wrapper wrapper-content animated fadeInUp">
        <div class="row">
            <div class="col-sm-12">

                <div class="ibox">
                    <div class="ibox-title">
                        <h5>JEECG-P3 微服务云应用插件开发  ， 提供更多通用业务插件，供用户下载使用 ~ </h5>
                        <!-- 
                        <div class="ibox-tools">
                            <a href="#" class="btn btn-primary btn-xs">创建新项目</a>
                        </div>
                         -->
                    </div>
                    <div class="ibox-content">
                        <div class="row m-b-sm m-t-sm">
                            <div class="col-md-1">
                                <button type="button" id="loading-example-btn" class="btn btn-white btn-sm"><i class="fa fa-refresh"></i> 刷新</button>
                            </div>
                            <div class="col-md-11">
                                <div class="input-group">
                                    <input type="text" placeholder="请输入项目名称" class="input-sm form-control"> <span class="input-group-btn">
                                        <button type="button" class="btn btn-sm btn-primary"> 搜索</button> </span>
                                </div>
                            </div>
                        </div>

                        <div class="project-list">

                            <table class="table table-hover">
                                <tbody>
                                
                                    <tr>
                                        <td class="project-status">
                                            <span class="label label-primary">进行中
                                        </td>
                                        <td class="project-title">
                                            <a href="#">Hello World</a>
                                            <br/>
                                            <small>创建于 2018.05.31</small>
                                        </td>
                                        <td class="project-completion">
                                                <small>当前进度： 90%</small>
                                                <div class="progress progress-mini">
                                                    <div style="width: 90%;" class="progress-bar"></div>
                                                </div>
                                        </td>
                                        <td class="project-people">
                                            <a href="#"><img alt="image" class="img-circle" src="plug-in-ui/hplus/img/a2.jpg"></a>
                                        </td>
                                        <td class="project-actions">
                                            <a href="hello.do?list" class="btn btn-white btn-sm"><i class="fa fa-cloud"></i> 演示</a>
                                            <a href="http://git.oschina.net/jeecg/jeecg-p3" class="btn btn-white btn-sm"><i class="fa fa-upload"></i> 下载</a>
                                        </td>
                                    </tr>
                                    
                                    
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    <!-- 全局js -->
    <script src="plug-in-ui/hplus/js/jquery.min.js?v=2.1.4"></script>
    <script src="plug-in-ui/hplus/js/bootstrap.min.js?v=3.3.6"></script>

    <script>
        $(document).ready(function(){

            $('#loading-example-btn').click(function () {
                btn = $(this);
                simpleLoad(btn, true)
                simpleLoad(btn, false)
            });
        });

        function simpleLoad(btn, state) {
            if (state) {
                btn.children().addClass('fa-spin');
                btn.contents().last().replaceWith(" Loading");
            } else {
                setTimeout(function () {
                    btn.children().removeClass('fa-spin');
                    btn.contents().last().replaceWith(" Refresh");
                }, 2000);
            }
        }
    </script>

    </body>
</html>
