sample
===
* 注释###

    select #use("cols")# from doctor  where  #use("condition")#

cols
===
	id,name,age,sex,department,text,user_id

updateSample
===

	id=#id#,name=#name#,age=#age#,sex=#sex#,department=#department#,text=#text#,user_id=#userId#

condition
===
= 1
    @if(!isEmpty(id)){
     and id=#id#
    @}
    @if(!isEmpty(name)){
     and name=#name#
    @}
    @if(!isEmpty(age)){
     and age=#age#
    @}
    @if(!isEmpty(sex)){
     and sex=#sex#
    @}
    @if(!isEmpty(department)){
     and department=#department#
    @}
    @if(!isEmpty(text)){
     and text=#text#
    @}
    @if(!isEmpty(userId)){
     and user_id=#userId#
    @}
