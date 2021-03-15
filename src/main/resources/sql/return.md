sample
===
* 注释###

    select #use("cols")# from return  where  #use("condition")#

cols
===
	id,registration_id,patient_id,doctor_id,status,describe

updateSample
===

	id=#id#,registration_id=#registrationId#,patient_id=#patientId#,doctor_id=#doctorId#,status=#status#,describe=#describe#

condition
===
= 1
    @if(!isEmpty(id)){
     and id=#id#
    @}
    @if(!isEmpty(registrationId)){
     and registration_id=#registrationId#
    @}
    @if(!isEmpty(patientId)){
     and patient_id=#patientId#
    @}
    @if(!isEmpty(doctorId)){
     and doctor_id=#doctorId#
    @}
    @if(!isEmpty(status)){
     and status=#status#
    @}
    @if(!isEmpty(describe)){
     and describe=#describe#
    @}
