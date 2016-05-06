$(document).ready(function () {
    //var  chart_config = {chart:{container: "#collapsable-example", rootOrientation:  'WEST', animateOnInit: true, node: { collapsable: true}, animation: {nodeAnimation: "easeOutBounce", nodeSpeed: 700, connectorsAnimation: "bounce", connectorsSpeed: 700}}, nodeStructure: { image: "imagenes/malory.png", children: [{ image:"imagenes/lana.png", children: [{ image: "imagenes/figgs.png"}] },{image:"imagenes/sterling.png", children: [ { image: "imagenes/woodhouse.png"}]},{image: "imagenes/cheryl.png"},{image: "imagenes/pam.png"}]}};
    $("#btn").click(function () {

        $.ajax({
            data: {accion: 1},
            url: 'vistaController',
            type: 'post',
            success: function (response) {
                tree = new Treant(JSON.parse(response));               
            }
        });

    });
});

//    var chart_config = {
//        chart: {
//            container: "#collapsable-example",
//            rootOrientation: 'WEST', // NORTH || EAST || WEST || SOUTH
//            animateOnInit: true,
//            node: {
//                collapsable: true
//            },
//            animation: {
//                nodeAnimation: "easeOutBounce",
//                nodeSpeed: 700,
//                connectorsAnimation: "bounce",
//                connectorsSpeed: 700
//            }
//        },
//        nodeStructure: {
//            image: "imagenes/malory.png",
//            children: [
//                {
//                    image: "imagenes/lana.png",
//                    children: [
//                        {
//                            image: "imagenes/figgs.png"
//                        }
//                    ]
//                },
//                {
//                    image: "imagenes/sterling.png",
//                    children: [
//                        {
//                            image: "imagenes/woodhouse.png"
//                        }
//                    ]
//                },
//                {
//                    image: "imagenes/cheryl.png"
//                },
//                {
//                    image: "imagenes/pam.png"
//                }
//            ]
//        }
//    };
//    var config = {
//        container: "#collapsable-example",
//        rootOrientation: 'WEST', // NORTH || EAST || WEST || SOUTH
//        animateOnInit: true,
//        node: {
//            collapsable: true
//        },
//        animation: {
//            nodeAnimation: "easeOutBounce",
//            nodeSpeed: 700,
//            connectorsAnimation: "bounce",
//            connectorsSpeed: 700
//        }
//    }
//    var malory = new Raiz("imagenes/malory.png",false);
//    var lana = new Nodo(malory, "imagenes/lana.png", false);
//    var figgs = new Nodo(lana, "imagenes/figgs.png", false);
//    var sterling = new Nodo(malory, "imagenes/sterling.png", false);
//    var woodhouse = new Nodo(sterling, "imagenes/woodhouse.png", false);
//    var cheryl = new Nodo(malory, "imagenes/cheryl.png", false);
//    var pam = new Nodo(malory, "imagenes/pam.png", true);
//    var chart_config = [config, malory, lana, figgs, sterling, woodhouse, pam, cheryl];