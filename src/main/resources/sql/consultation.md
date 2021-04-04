sample
===
* 注释###

    select #use("cols")# from consultation  where  #use("condition")#

cols
===
	id,describes,days,price,patient_id,doctor_id,reply

updateSample
===

	id=#id#,describes=#describes#,days=#days#,price=#price#,patient_id=#patientId#,doctor_id=#doctorId#,reply=#reply#

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
    @if(!isEmpty(doctorId)){
     and doctor_id=#doctorId#
    @}
    @if(!isEmpty(reply)){
         and reply=#reply#
        @}
        
selectList
===
        SELECT
             #page("d.*")#
        FROM
            consultation d
        Where 1=1
            @if(!isEmpty(patientId)){
                 and d.patient_id = #patientId#
            @}
            @if(!isEmpty(doctorId)){
                             and d.doctor_id = #doctorId#
                        @}
