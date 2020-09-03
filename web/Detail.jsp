<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@ page contentType="text/html; charset=UTF-8" %>

<html>
    <head>      
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
        <script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
        <!-- getmdl-modal -->
        <link rel="stylesheet" href="css/material-modal.min.css">
        <!-- mobile view -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href="css/mdDateTimePicker.css">
        <script src="js/moment.js"></script>
        <script src="js/mdDateTimePicker.js"></script>
        <style>
            .mdl-grid.center-items {
                justify-content: center;
            }
        </style>
        <meta charset="UTF-8">
        <style>
            .footer {
                height: 50px; 
                display: block;
                text-align: center;
                background-color:#3f51b5;
                color:#fff;
                margin-top: 20%;
            }
            .logo {
                height:100px;
                width: 100%;  
                max-width:100px; 
                display: block;
            }
             .imgcompany{
                height: 70px;
                width: 100px;
                overflow: hidden;
                text-align: center;
                float: left;
            }


        </style>

    </head>
    <body>
        <div class="mdl-layout__container" >
            <!-- Material Design-->
            <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
                <header class="mdl-layout__header">
                    <div class="mdl-layout__header-row">
                        <!-- Title -->
                         <a href="index.html"> <img src="img/logo.png" class="mdl-layout-title logo" > </a>
                        <!-- Add spacer, to align navigation to the right -->
                        <div class="mdl-layout-spacer"></div>
                        <!-- Navigation. We hide it in small screens. -->
                        <nav class="mdl-navigation mdl-layout--large-screen-only">
                            <a class="mdl-navigation__link" href="">ประกันสุขภาพ</a>
                            <a class="mdl-navigation__link" href="">ประกันชีวิต</a>
                            <a class="mdl-navigation__link" href="">วงเงินประกัน</a>
                            <a class="mdl-navigation__link" href="">สิทธิพิเศษ</a>
                            <a class="mdl-navigation__link" href="">วางแผนหลังเกษียณอายุ</a>
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable
                                 mdl-textfield--floating-label mdl-textfield--align-right">
                                <label class="mdl-button mdl-js-button mdl-button--icon"
                                       for="fixed-header-drawer-exp">
                                    <i class="material-icons">search</i>
                                </label>
                                <div class="mdl-textfield__expandable-holder">
                                    <input class="mdl-textfield__input" type="text" name="sample"
                                           id="fixed-header-drawer-exp">
                        </nav>
                    </div>

                </header>
                <main class="mdl-layout__content">
                    <div class="page-content mdl-grid"><!-- Your content goes here -->
                        <!------- Grid -------->
                        <div class="mdl-cell mdl-cell--3-col">   
                            <div class="demo-card-square mdl-card mdl-shadow--2dp">
                                <!-- Header-->
                                <div class=" mdl-card__header mdl-color--primary mdl-color-text--white mdl-card--expand" >                                                                      
                                    <h2 class="mdl-card__title-text mdl-cell--2-col "></h2>
                                    <h2 class="mdl-card__title-text mdl-cell--8-col" >ประกันคุ้มครองชีวิต</h2>
                                    <h2 class="mdl-card__title-text mdl-cell--2-col "></h2>                                    
                                </div>
                                <!--รับค่าเบี้ยประกัน-->
                                <div class="mdl-card__title mdl-card--expand">
                                    <h2 class="mdl-card__title-text mdl-cell--6-col "><img src="img/tk.jpg" class="mdl-layout-title imgcompany" ></h2>
                                    <h2 class="mdl-card__title-text mdl-cell--6-col "><%=request.getParameter("resultChip")%> บาท</h2>
                                </div>
                                <div class="mdl-card__supporting-text">
                                    <table style="width:100%">
                                        <tr>
                                            <td>ทุนประกันเสียชีวิต 15ปี</td>
                                            <td><%=request.getParameter("resultEn15")%> บาท</td>
                                        </tr>
                                        <tr>
                                            <td>ทุนประกันเสียชีวิต 20ปี</td>
                                            <td><%=request.getParameter("resultEn20")%> บาท</td>
                                        </tr>
                                    </table>
                                </div>
                                <div class="mdl-card__actions mdl-card--border  mdl-typography--text-center">
                                    <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect mdl-button--raised modal__trigger" data-modal="#modal"">
                                        ติดต่อ
                                    </a>
                                </div>
                            </div>
                        </div>

                        <div id="modal" class="modal modal__bg " align="center">
                            <div class="modal__dialog ">
                                <div class="modal__content " style=" width: 340px !important; height: 500 !important; max-height: calc(125vh - 320px) !important; overflow:scroll ">
                                    <div class="modal__header">
                                        <div class="modal__header">
                                            <h6 class="modal__title-text">กรุณากรอกข้อมูลต่อไปนี้</h6>
                                            <!-- <span class="mdl-button mdl-button--icon mdl-js-button  material-icons modal__close"></span> -->
                                        </div>
                                    </div>
                                    <div class="modal__body">
                                        <form action="">
                                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                                <input class="mdl-textfield__input" type="text" id="name">
                                                <label class="mdl-textfield__label" for="name">ฃื่อ</label>
                                            </div>
                                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                                <input class="mdl-textfield__input" type="text" id="lastname">
                                                <label class="mdl-textfield__label" for="lastname">นามสกุล</label>
                                            </div>
                                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                                <input class="mdl-textfield__input" type="text" pattern="[0-9]*([0-9])" id="numphone">
                                                <label class="mdl-textfield__label" for="numphone">เบอร์มือถือ</label>
                                                <span class="mdl-textfield__error">กรุณาใส่ตัวเลข</span>
                                            </div>
                                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                                <input class="mdl-textfield__input" type="text" id="email">
                                                <label class="mdl-textfield__label" for="email">อีเมลล์</label>
                                            </div>
                                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                                <input class="mdl-textfield__input" type="date" id="date">
                                                <label class="mdl-textfield__label" for="date"></label>
                                            </div>
                                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                                <input class="mdl-textfield__input" type="time" id="time">
                                                <label class="mdl-textfield__label" for="time"></label>
                                            </div>  
                                        </form>
                                    </div>
                                    <div class="modal__footer ">
                                        <a class="mdl-button mdl-button--colored mdl-js-button modal__close">
                                            ยกเลิก
                                        </a>
                                        <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect mdl-button--raised modal__trigger" href="index.jsp">
                                            ติดต่อ
                                        </a>

                                    </div>
                                </div>
                            </div>

                        </div>
                        <!-- Modal link -->
                        <script src="https://storage.googleapis.com/code.getmdl.io/1.0.5/material.min.js"></script> <!-- MDL JavaScript -->
                        <script src="js/material-modal.min.js"></script> 



                        <div class="mdl-cell mdl-cell--1-col"></div>  
                        <div class="mdl-cell mdl-cell--7-col">
                            <div class="demo-content mdl-color--white mdl-shadow--4dp content mdl-color-text--grey-800 ">
                                <div>
                                    <table class="table table-hover">
                                        <thead>
                                            <tr>
                                                <th>ประกันคุ้มครองชีวิต</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>ทุนประกันเสียชีวิต 15ปี</td>
                                                <td><%=request.getParameter("resultEn15")%> บาท</td>
                                            </tr>
                                            <tr>
                                                <td>ทุนประกันเสียชีวิต 20ปี</td>
                                                <td><%=request.getParameter("resultEn20")%> บาท</td>
                                            </tr>
                                            <tr>
                                                <td>จ่ายเบี้ยปีละ</td>
                                                <td><%=request.getParameter("resultChip")%> บาท</td>
                                            </tr>
                                        </tbody>
                                    </table>                
                                </div>          
                            </div>

                        </div>
                        <div class="mdl-cell mdl-cell--1-col"></div> 

                    </div>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <footer>
                        <div class="footer" ><br/>
                            Ensure Your insurance     &copy;2017
                        </div>
                    </footer>
                </main>

            </div>

        </div>


    </body>

</html>
