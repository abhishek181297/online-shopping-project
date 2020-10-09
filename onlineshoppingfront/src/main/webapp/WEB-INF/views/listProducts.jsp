<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <div class="row">
        <%--  Would be to Display sidebar      --%>
        <div class="col-lg-3">
            <%@include file="./shared/categories_sidebar.jsp"%>
        </div>
        <%--   to display actual products    --%>
        <div class="col-lg-9">
            <div class="row">
                <div class="col-lg-12">
                    <c:if test="${userClickAllProducts == true}">
                        <ul class="breadcrumb">

                            <li><a href="${contextRoot}/home">Home</a></li> /
                            <li class="active">All Products</li>

                        </ul>
                    </c:if>

                    <c:if test="${userClickCategoryProducts == true}">
                        <ul class="breadcrumb">

                            <li><a href="${contextRoot}/home">Home</a></li> /
                            <li class="active">Category</li> /
                            <li class="active">${category.name}</li>
                        </ul>
                    </c:if>
                </div>
            </div>
        </div>

    </div>

</div>