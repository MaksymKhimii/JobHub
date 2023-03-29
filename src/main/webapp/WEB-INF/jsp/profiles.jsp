<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="jobhub" tagdir="/WEB-INF/tags"%>

<div class="row profiles">
    <div id="profileContainer" class="col-xs-12" data-profile-total="${page.totalPages }" data-profile-number="${page.number }">
        <jsp:include page="fragment/profile-items.jsp" />
    </div>
    <c:if test="${page.number < page.totalPages - 1}">
        <div id="loadMoreContainer" class="col-xs-12 text-center">
            <a href="javascript:moreProfiles();" class="btn btn-primary">Load more</a>
        </div>
        <div id="loadMoreIndicator" class="col-xs-12 text-center" style="display:none;">
            <img src="../../static/img/large-loading.gif" alt="loading..."/>
        </div>
    </c:if>
</div>
<script>
    function moreProfiles() {
        var page = parseInt($('#profileContainer').attr('data-profile-number')) + 1;
        var total = parseInt($('#profileContainer').attr('data-profile-total'));
        if (page >= total) {
            $('#loadMoreIndicator').remove();
            $('#loadMoreContainer').remove();
            return;
        }
        var url = '/fragment/more?page=' + page;

        $('#loadMoreContainer').css('display', 'none');
        $('#loadMoreIndicator').css('display', 'block');
        $.ajax({
            url: url,
            success: function (data) {
                $('#loadMoreIndicator').css('display', 'none');
                $('#profileContainer').append(data);
                $('#profileContainer').attr('data-profile-number', page);
                if (page >= total - 1) {
                    $('#loadMoreIndicator').remove();
                    $('#loadMoreContainer').remove();
                } else {
                    $('#loadMoreContainer').css('display', 'block');
                }
            },
            error: function (data) {
                $('#loadMoreIndicator').css('display', 'none');
                resume.alert('Error! Try again later...');
            }
        })
    };
</script>