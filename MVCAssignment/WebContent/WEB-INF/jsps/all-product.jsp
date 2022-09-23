<%@page import="com.spring.main.model.Product" %>
    <%@page import="java.util.List" %>
        <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="ISO-8859-1">
                <title>Yash's Product Page</title>
                <style type="text/css">
                    .block1 {
                        border: 5px solid rgb(0, 64, 175);
                        padding: 30px;
                        width: 50%;
                        float: left;
                        margin: 10px;
                        background: rgb(130, 162, 238);
                        color: rgb(0, 0, 0);
                        font-family: cambria;
                        font-size: large;
                    }

                    .block2 {
                        border: 5px solid rgb(0, 64, 175);
                        padding: 30px;
                        width: 30%;
                        float: left;
                        margin: 10px;
                        background: rgb(130, 162, 238);
                        color: rgb(0, 0, 0);
                        font-family: cambria;
                        font-size: large;
                    }
                </style>
            </head>

            <body>
                <section>
                    <div class="block1">
                        <h1>All products</h1>
                        <% List<Product> list=(List<Product>)request.getAttribute("list");

                                Product product=(Product)request.getAttribute("product");
                                for(Product p:list){

                                %>
                                <%=p %> &nbsp;&nbsp; <a
                                        href="<%=request.getContextPath() %>/delete-product?id=<%=p.getId()%>"
                                        onclick='return confirm("Are you sure you want to delete?")'>DELETE</a>
                                    &nbsp; &nbsp; &nbsp;|&nbsp; &nbsp; &nbsp; <a
                                        href="<%=request.getContextPath() %>/edit-product?id=<%=p.getId()%>">EDIT</a>
                                    <br />
                                    <br />
                                    <br />

                                    <% } %>
                    </div>

                    <div class="block2">
                        <%String flag=(String)request.getAttribute("flag"); %>
                            <%if(flag==null){ %>
                                <h3>ADD PRODUCT</h3>
                                <form action="<%=request.getContextPath()%>/insert-product" method="get">
                                    <label>Name: </label>
                                    <input type="text" name="ename">
                                    <br /><br />
                                    <label>Cost: </label>
                                    <input type="number" name="eprice">
                                    <br /><br />
                                    <label>Specifications: </label>
                                    <input type="text" name="edescription">
                                    <br /><br />
                                    <label>Category: </label>
                                    <input type="text" name="ecategory">
                                    <br /><br />
                                    <input type="submit" value="Add Product">
                                    <%} else { %>
                                        <h3>Edit Product</h3>
                                </form>

                                <form action="<%=request.getContextPath()%>/edit-product-op" method="get">
                                    <input type="hidden" name="id" value=<%=product.getId() %>>
                                    <label>Name: </label>
                                    <input type="text" name="ename" value=<%=product.getName() %>>
                                    <br /><br />
                                    <label>Cost: </label>
                                    <input type="number" name="eprice" value=<%=product.getPrice() %>>
                                    <br /><br />
                                    <label>Specifications: </label>
                                    <input type="text" name="edescription" value=<%=product.getDescription() %>>
                                    <br /><br />
                                    <label>Category: </label>
                                    <input type="text" name="ecategory" value=<%=product.getCategory() %>>
                                    <br /><br />
                                    <input type="submit" value="Edit Product">
                                </form>
                                <%} %>
                    </div>
                </section>
            </body>

            </html>