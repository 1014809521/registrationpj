sample
===
* 注释###

    select #use("cols")# from patient  where  #use("condition")#

cols
===
	id,name,age,sex,registration_id,user_id

updateSample
===

	id=#id#,name=#name#,age=#age#,sex=#sex#,registration_id=#registrationId#,user_id=#userId#

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
    @if(!isEmpty(registrationId)){
     and registration_id=#registrationId#
    @}
    @if(!isEmpty(userId)){
     and user_id=#userId#
    @}
