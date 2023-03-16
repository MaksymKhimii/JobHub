<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="jobhub" tagdir="/WEB-INF/tags" %>

<div class="container">
    <div class="row">
        <div class="col-md-4 col-sm-6">
            <jobhub:profile-main />
            <div class="hidden-xs">
                <jobhub:profile-languages />
                <jobhub:profile-hobbies />
                <jobhub:profile-info />
            </div>
        </div>
        <div class="col-md-8 col-sm-6">
            <jobhub:profile-objective/>
            <jobhub:profile-skills />
            <jobhub:profile-practics />
            <jobhub:profile-certificates/>
            <jobhub:profile-cources/>
            <jobhub:profile-education />
        </div>
        <div class="col-xs-12 visible-xs-block">
            <jobhub:profile-languages />
            <jobhub:profile-hobbies />
            <jobhub:profile-info />
        </div>
    </div>
</div>