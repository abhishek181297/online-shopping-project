
$(function() {
    console.log(menu);
    switch(menu) {
        case 'About' :
            $('#about').addClass('active');
            break;
        case 'Contact' :
            $('#contact').addClass('active');
            break;
        case 'All Products':
            $('#listProducts').addClass('active');
            break;
        case 'Home':
            $('#home').addClass('active');
            break;
        default:
            $('#listProducts').addClass('active');
            $('#a_sb_'+menu).addClass('active')
    }
});