<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jobhub" tagdir="/WEB-INF/tags" %>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-sm-6">
            <jobhub:profile-main/>
            <jobhub:profile-languages/>
            <jobhub:profile-hobbies/>
            <jobhub:profile-info/>
        </div>
        <div class="col-md-8 col-sm-6">
            <jobhub:profile-objective/>
            <jobhub:profile-skills />
            <jobhub:profile-practics />
            <jobhub:profile-certificates/>
            <jobhub:profile-cources/>
            <jobhub:profile-education />
        </div>
    </div>
</div>
