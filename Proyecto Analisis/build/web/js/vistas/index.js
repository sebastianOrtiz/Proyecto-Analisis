var config = {
        container: "#OrganiseChart1",
        rootOrientation:  'WEST', // NORTH || EAST || WEST || SOUTH
        // levelSeparation: 30,
        siblingSeparation:   20,
        subTeeSeparation:    60,
        scrollbar: "fancy",
        
        connectors: {
            type: 'step'
        },
        node: {
            HTMLclass: 'nodeExample1',
            
        }
    },
    sebas = {
        text: {
            name: "Mark Hill",
            title: "Chief executive officer",
            contact: "Tel: 01 213 123 134",
        },
        image: "imagenes/2.jpg",
        HTMLid: "sebas"
    },

    cto = {
        parent: sebas,
        text:{
            name: "Joe Linux",
            title: "Chief Technology Officer",
        },
        stackChildren: true,
        image: "imagenes/1.jpg",
        HTMLid: "coo"
    },
    cbo = {
        parent: sebas,
        text:{
            name: "Linda May",
            title: "Chief Business Officer",
        },
        image: "imagenes/5.jpg",
        HTMLid: "cbo"
    },
    cdo = {
        parent: sebas,
        text:{
            name: "John Green",
            title: "Chief accounting officer",
            contact: "Tel: 01 213 123 134",
        },
        image: "imagenes/6.jpg",
        HTMLid: "cdo"
    },
    cio = {
        parent: cto,
        text:{
            name: "Ron Blomquist",
            title: "Chief Information Security Officer"
        },
        image: "imagenes/8.jpg",
        HTMLid: "cio"
    },
    ciso = {
        parent: cto,
        text:{
            name: "Michael Rubin",
            title: "Chief Innovation Officer",
            contact: "we@aregreat.com"
        },
        image: "imagenes/9.jpg",
        HTMLid: "ciso"
    },
    cio2 = {
        parent: cdo,
        text:{
            name: "Erica Reel",
            title: "Chief Customer Officer"
        },
        link: {
            href: "http://www.google.com",
            target: "_blank"
        },
        image: "imagenes/10.jpg",
        HTMLid: "cio2"
    },
    ciso2 = {
        parent: cbo,
        text:{
            name: "Alice Lopez",
            title: "Chief Communications Officer"
        },
        image: "imagenes/7.jpg",
        HTMLid: "ciso2"
    },
    ciso3 = {
        parent: cbo,
        text:{
            name: "Mary Johnson",
            title: "Chief Brand Officer"
        },
        image: "imagenes/4.jpg",
        HTMLid: "ciso2"
    },
    ciso4 = {
        parent: cbo,
        text:{
            name: "Kirk Douglas",
            title: "Chief Business Development Officer"
        },
        image: "imagenes/11.jpg",
        HTMLid: "ciso2"
    }

    ALTERNATIVE = [
        config,
        sebas,
        cto,
        cbo,
        cdo,
        cio,
        ciso,
        cio2,
        ciso2,
        ciso3,
        ciso4
    ];
    
    $("#btn1").click(function (){
        new Treant( ALTERNATIVE );
    });