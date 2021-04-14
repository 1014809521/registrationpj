sample
===
* 注释###

    select #use("cols")# from seek  where  #use("condition")#

cols
===
	id,describes,days,price,patient_id,illness,drug

updateSample
===

	id=#id#,describes=#describes#,days=#days#,price=#price#,patient_id=#patientId#,illness=#illness#,drug=#drug#

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
    @if(!isEmpty(illness)){
     and illness=#illness#
    @}
    @if(!isEmpty(drug)){
         and drug=#drug#
        @}
    
    
selectList
===
        SELECT
             #page("d.*")#
        FROM
            seek d
        Where 1=1
            @if(!isEmpty(patientId)){
                 and d.patient_id = #patientId#
            @}
            @if(!isEmpty(registrationId)){
                             and d.registrationId = #registrationId#
                        @}