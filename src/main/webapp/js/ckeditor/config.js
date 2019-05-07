/*
Copyright (c) 2003-2010, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
*/

CKEDITOR.editorConfig = function( config )
{
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
	
	
	config.filebrowserImageBrowseUrl = '../js/ckfinder/ckfinder.html?Type=Images';
	config.filebrowserFlashBrowseUrl = '../js/ckfinder/ckfinder.html?Type=Flash';
	config.filebrowserUploadUrl = '../ckfinder/core/connector/aspx/connector.aspx?command=QuickUpload&type=Files';
	config.filebrowserImageUploadUrl = '/goods/ckeditorUpload.do';
	config.filebrowserFlashUploadUrl = '../ckfinder/core/connector/aspx/connector.aspx?command=QuickUpload&type=Flash';
	config.uiColor = '#ddeeff';
    config.language = 'zh-cn'; 
	config.width = '100%'; 
	
	config.filebrowserUploadUrl = "/goods/ckeditorUpload.do";
};
