
$(function() {
    switch(menu) {
        case 'About' :
            $('#about').addClass('active');
//            $('#home').removeClass('active');
//            $('#contact').removeClass('active');
//            $('#listProducts').removeClass('active');
            break;
        case 'Contact' :
//            $('#about').removeClass('active');
//            $('#home').removeClass('active');
            $('#contact').addClass('active');
//            $('#listProducts').removeClass('active');
            break;
        default:
//        $('#about').removeClass('active');
        $('#home').addClass('active');
//        $('#contact').removeClass('active');
//        $('#listProducts').removeClass('active');
    }
});