<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0,viewport-fit=cover">

	<link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.2/weui-for-work.css"/>
	<link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.2/weui-for-work.min.css"/>
	
<title>WeUI for work</title>
</head>
<body>
	<div class="weui-toptips weui-toptips_warn js_tooltips">错误提示</div>
	<div class="weui-cells__title">文本域</div>
        <div class="weui-cells weui-cells_form">
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <textarea class="weui-textarea" placeholder="请输入文本" rows="3"></textarea>
                    <div class="weui-textarea-counter"><span>0</span>/200</div>
                </div>
            </div>
        </div>
        <div class="weui-cells__title">选择</div>
        <div class="weui-cells">
            <div class="weui-cell weui-cell_select">
                <div class="weui-cell__bd">
                    <select class="weui-select" name="select1">
                        <option selected="" value="1">微信号</option>
                        <option value="2">QQ号</option>
                        <option value="3">Email</option>
                    </select>
                </div>
            </div>
            <div class="weui-cell weui-cell_select weui-cell_select-after">
                <div class="weui-cell__hd">
                    <label for="" class="weui-label">国家/地区</label>
                </div>
                <div class="weui-cell__bd">
                    <select class="weui-select" name="select2">
                        <option value="1">中国</option>
                        <option value="2">美国</option>
                        <option value="3">英国</option>
                    </select>
                </div>
            </div>
        </div>
        
        <div class="page">
    <div class="page__hd">
        <h1 class="page__title">Button</h1>
        <p class="page__desc">按钮</p>
    </div>
    <div class="page__bd page__bd_spacing">
        <a href="javascript:;" class="weui-btn weui-btn_primary">页面主操作 Normal</a>
		<a href="javascript:;" class="weui-btn weui-btn_primary weui-btn_loading"><i class="weui-loading"></i>页面主操作 Loading</a>
        <a href="javascript:;" class="weui-btn weui-btn_disabled weui-btn_primary">页面主操作 Disabled</a>
        <a href="javascript:;" class="weui-btn weui-btn_default">页面次要操作 Normal</a>
		<a href="javascript:;" class="weui-btn weui-btn_default weui-btn_loading"><i class="weui-loading"></i>页面次操作 Loading</a>
        <a href="javascript:;" class="weui-btn weui-btn_disabled weui-btn_default">页面次要操作 Disabled</a>
        <a href="javascript:;" class="weui-btn weui-btn_warn">警告类操作 Normal</a>
		<a href="javascript:;" class="weui-btn weui-btn_warn weui-btn_loading"><i class="weui-loading"></i>警告类操作 Loading</a>
        <a href="javascript:;" class="weui-btn weui-btn_disabled weui-btn_warn">警告类操作 Disabled</a>
        
        <div class="button-sp-area">
            <a href="javascript:;" class="weui-btn weui-btn_plain-default">按钮</a>
            <a href="javascript:;" class="weui-btn weui-btn_plain-default weui-btn_plain-disabled">按钮</a>
            <a href="javascript:;" class="weui-btn weui-btn_plain-primary">按钮</a>
            <a href="javascript:;" class="weui-btn weui-btn_plain-primary weui-btn_plain-disabled">按钮</a>
            <a href="javascript:;" class="weui-btn weui-btn_mini weui-btn_primary">按钮</a>
            <a href="javascript:;" class="weui-btn weui-btn_mini weui-btn_default">按钮</a>
            <a href="javascript:;" class="weui-btn weui-btn_mini weui-btn_warn">按钮</a>
        </div>
    </div>
    

    
</div>
        <img src="./images/icon_footer_link.png" />
        <div class="weui-cells__title">表单</div>
        <div class="weui-cells weui-cells_form">
            <div class="weui-cell">
                <div class="weui-cell__hd"><label class="weui-label">qq</label></div>
                <div class="weui-cell__bd">
                    <input class="weui-input" type="number" pattern="[0-9]*" placeholder="请输入qq号"/>
                </div>
            </div>
            <div class="weui-cell weui-cell_vcode">
                <div class="weui-cell__hd">
                    <label class="weui-label">手机号</label>
                </div>
                <div class="weui-cell__bd">
                    <input class="weui-input" type="tel" placeholder="请输入手机号"/>
                </div>
                <div class="weui-cell__ft">
                    <button class="weui-vcode-btn">获取验证码</button>
                </div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__hd"><label for="" class="weui-label">日期</label></div>
                <div class="weui-cell__bd">
                    <input class="weui-input" type="date" value=""/>
                </div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__hd"><label for="" class="weui-label">时间</label></div>
                <div class="weui-cell__bd">
                    <input class="weui-input" type="datetime-local" value="" placeholder=""/>
                </div>
            </div>
            <div class="weui-cell weui-cell_vcode">
                <div class="weui-cell__hd"><label class="weui-label">验证码</label></div>
                <div class="weui-cell__bd">
                    <input class="weui-input" type="number" placeholder="请输入验证码"/>
                </div>
                <div class="weui-cell__ft">
                    <img class="weui-vcode-img" src="./images/vcode.jpg" />
                </div>
            </div>
        </div>
        <div class="weui-cells__tips">底部说明文字底部说明文字</div>

        <div class="weui-cells__title">表单报错</div>
        <div class="weui-cells weui-cells_form">
            <div class="weui-cell weui-cell_warn">
                <div class="weui-cell__hd"><label for="" class="weui-label">卡号</label></div>
                <div class="weui-cell__bd">
                    <input class="weui-input" type="number" pattern="[0-9]*" value="weui input error" placeholder="请输入卡号"/>
                </div>
                <div class="weui-cell__ft">
                    <i class="weui-icon-warn"></i>
                </div>
            </div>
        </div>


        <div class="weui-cells__title">开关</div>
        <div class="weui-cells weui-cells_form">
            <div class="weui-cell weui-cell_switch">
                <div class="weui-cell__bd">标题文字</div>
                <div class="weui-cell__ft">
                    <input class="weui-switch" type="checkbox"/>
                </div>
            </div>
            <div class="weui-cell weui-cell_switch">
                <div class="weui-cell__bd">兼容IE Edge的版本</div>
                <div class="weui-cell__ft">
                    <label for="switchCP" class="weui-switch-cp">
                        <input id="switchCP" class="weui-switch-cp__input" type="checkbox" checked="checked"/>
                        <div class="weui-switch-cp__box"></div>
                    </label>
                </div>
            </div>
        </div>
</body>
</html>