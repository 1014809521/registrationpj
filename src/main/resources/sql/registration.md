sample
===
* 注释###

    select #use("cols")# from registration  where  #use("condition")#

cols
===
	id,patient_id,doctor_id,time,expenses,status

updateSample
===

	id=#id#,patient_id=#patientId#,doctor_id=#doctorId#,time=#time#,expenses=#expenses#,status=#status#

condition
===
= 1
    @if(!isEmpty(id)){
     and id=#id#
    @}
    @if(!isEmpty(patientId)){
     and patient_id=#patientId#
    @}
    @if(!isEmpty(doctorId)){
     and doctor_id=#doctorId#
    @}
    @if(!isEmpty(time)){
     and time=#time#
    @}
    @if(!isEmpty(expenses)){
     and expenses=#expenses#
    @}
    @if(!isEmpty(status)){
     and status=#status#
    @}
