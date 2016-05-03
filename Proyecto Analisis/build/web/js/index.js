/*
    var chart_config = {
        chart: {
            container: "#collapsable-example",
            rootOrientation:  'WEST', // NORTH || EAST || WEST || SOUTH
            animateOnInit: true,
            
            node: {
                collapsable: true
            },
            animation: {
                nodeAnimation: "easeOutBounce",
                nodeSpeed: 700,
                connectorsAnimation: "bounce",
                connectorsSpeed: 700
            }
        },
        nodeStructure: {
            image: "imagenes/malory.png",
            children: [
                {
                    image: "imagenes/lana.png",
                    collapsed: true,
                    children: [
                        {
                            image: "imagenes/figgs.png"
                        }
                    ]
                },
                {
                    image: "imagenes/sterling.png",
                    childrenDropLevel: 1,
                    children: [
                        {
                            image: "imagenes/woodhouse.png"
                        }
                    ]
                },
                {
                    pseudo: true,
                    children: [
                        {
                            image: "imagenes/cheryl.png"
                        },
                        {
                            image: "imagenes/pam.png"
                        }
                    ]
                }
            ]
        }
    };
*/
/* Array approach
*/
    var config = {
        container: "#collapsable-example",
        rootOrientation:  'WEST', // NORTH || EAST || WEST || SOUTH
        animateOnInit: true,
        
        node: {
            collapsable: true
        },
        animation: {
            nodeAnimation: "easeOutBounce",
            nodeSpeed: 700,
            connectorsAnimation: "bounce",
            connectorsSpeed: 700
        }
    },
    malory = {
        image: "imagenes/malory.png"
    },

    lana = {
        parent: malory,
        image: "imagenes/lana.png",
        collapsed:true
    }

    figgs = {
        parent: lana,
        image: "imagenes/figgs.png"
    }

    sterling = {
        parent: malory,
        
        image: "imagenes/sterling.png"
    },

    woodhouse = {
        parent: sterling,
        image: "imagenes/woodhouse.png"
    },
/*
    pseudo = {
        parent: malory,
        pseudo: true
    },*/

    cheryl = {
        parent: malory,
        image: "imagenes/cheryl.png"
    },

    pam = {
        parent: malory,
        image: "imagenes/pam.png"
    },

    chart_config = [config, malory, lana, figgs,/*pseudo,*/ sterling, woodhouse, pam, cheryl];

    $("#btn").click(function () {
        tree = new Treant( chart_config );
    });
