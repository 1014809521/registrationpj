sample
===
* 注释###

    select #use("cols")# from department  where  #use("condition")#

cols
===
	id,name,type

updateSample
===

	id=#id#,name=#name#,type=#type#

condition
===
= 1
    @if(!isEmpty(id)){
     and id=#id#
    @}
    @if(!isEmpty(name)){
     and name=#name#
    @}
    @if(!isEmpty(type)){
     and type=#type#
    @}
