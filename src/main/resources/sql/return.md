sample
===
* 注释###

    select #use("cols")# from return  where  #use("condition")#

cols
===
	id,registration_id,patient_id,doctor_id,question,describe

updateSample
===

	id=#id#,registration_id=#registrationId#,patient_id=#patientId#,doctor_id=#doctorId#,question=#question#,describe=#describe#

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
    @if(!isEmpty(question)){
     and question=#question#
    @}
    @if(!isEmpty(describe)){
     and describe=#describe#
    @}
    
selectList
===
        SELECT
             #page("d.*")#
        FROM
            graduation.return d
        Where 1=1
            @if(!isEmpty(patientId)){
                 and d.patient_id = #patientId#
            @}
            @if(!isEmpty(doctorId)){
                   and d.doctor_id = #doctorId#
                        @}
            @if(!isEmpty(registrationId)){
                               and d.registration_id = #registrationId#
                                    @}
