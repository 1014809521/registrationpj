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
    
    
selectList
===     
        SELECT
        	#page("a.*,p.name AS patientName,d.name AS doctorName,d.department AS department")#
        FROM
        	registration a
        LEFT JOIN patient p ON a.patient_id = p.id
        LEFT JOIN doctor d ON d.id = a.doctor_id where 1=1
            @if(!isEmpty(patientName)){
                and p.name like concat('%',#patientName#,'%')
            @}
            @if(!isEmpty(doctorName)){
                and d.name like concat('%',#doctorName#,'%')
            @}
            @if(!isEmpty(userId)){
                and p.user_id = #userId#
            @}
            @if(!isEmpty(doctorId)){
                            and a.doctor_id = #doctorId#
                        @}
