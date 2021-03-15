sample
===
* 注释###

    select #use("cols")# from consultation  where  #use("condition")#

cols
===
	id,describes,days,price,patient_id,registration_id

updateSample
===

	id=#id#,describes=#describes#,days=#days#,price=#price#,patient_id=#patientId#,registration_id=#registrationId#

condition
===
= 1
    @if(!isEmpty(id)){
     and id=#id#
    @}
    @if(!isEmpty(describes)){
     and describes=#describes#
    @}
    @if(!isEmpty(days)){
     and days=#days#
    @}
    @if(!isEmpty(price)){
     and price=#price#
    @}
    @if(!isEmpty(patientId)){
     and patient_id=#patientId#
    @}
    @if(!isEmpty(registrationId)){
     and registration_id=#registrationId#
    @}
