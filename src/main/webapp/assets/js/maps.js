(($) => {
    $(document).ready(() => {
        const $map = $('.map_container');
        const map = new google.maps.Map(
            $map[0], {
                center: {
                    lat:21.035740,
                    lng: 105.768253
                },
                zoom: 13,
                styles: [{
                    "stylers": [{
                        "saturation": 5
                    },
                        {
                            "lightness": 5
                        },
                        {
                            "weight": 1.5
                        }
                    ]
                },
                    {
                        "elementType": "labels.text.fill",
                        "stylers": [{
                            "color": "#804701"
                        }]
                    },
                    {
                        "elementType": "labels.text.stroke",
                        "stylers": [{
                            "color": "#fdfdff"
                        }]
                    },
                    {
                        "featureType": "administrative.land_parcel",
                        "elementType": "labels",
                        "stylers": [{
                            "visibility": "off"
                        }]
                    },
                    {
                        "featureType": "poi",
                        "elementType": "labels.text",
                        "stylers": [{
                            "visibility": "off"
                        }]
                    },
                    {
                        "featureType": "poi.business",
                        "stylers": [{
                            "visibility": "off"
                        }]
                    },
                    {
                        "featureType": "road",
                        "elementType": "labels.icon",
                        "stylers": [{
                            "visibility": "off"
                        }]
                    },
                    {
                        "featureType": "road.arterial",
                        "elementType": "labels",
                        "stylers": [{
                            "visibility": "off"
                        }]
                    },
                    {
                        "featureType": "road.highway",
                        "elementType": "labels",
                        "stylers": [{
                            "visibility": "off"
                        }]
                    },
                    {
                        "featureType": "road.local",
                        "stylers": [{
                            "visibility": "off"
                        }]
                    },
                    {
                        "featureType": "road.local",
                        "elementType": "labels",
                        "stylers": [{
                            "visibility": "off"
                        }]
                    },
                    {
                        "featureType": "transit",
                        "stylers": [{
                            "visibility": "off"
                        }]
                    }
                ]
            });
        const markerImage = {
            url: 'assets/img/icons/map-marker.png',
            scaledSize: new google.maps.Size(100, 100),
            origin: new google.maps.Point(0, 0),
            anchor: new google.maps.Point(50, 50)
        };
        const marker = new google.maps.Marker({
            position: {
                lat:21.035740,
                lng: 105.768253
            },
            map: map,
            icon: markerImage
        });
    });
})(jQuery)