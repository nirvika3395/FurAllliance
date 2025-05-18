<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<c:if test="${not empty error}">
    <p class="error-message">${error}</p>
</c:if>

<c:if test="${not empty success}">
    <p class="success-message">${success}</p>
</c:if>
