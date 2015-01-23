function initImageSlid()
{ 
 	var slideshows
        
        if(slideshows)       
		$('.slideshow_image').cycle('destroy'); 

		slideshows = $('.slideshow_image').cycle();/*{
		fx: 'scrollHorz',
		speed: 300,
		timeout: 4000,
		randomizeEffects: false,
		easing: 'easeOutCubic',
		// pauses the slideshow, slideshow can be resumed with 'resume' command 

		cleartypeNoBg: true,
		after:function(currSlideElement, nextSlideElement, options, forwardFlag){


		$("#slideName").html(nextSlideElement.src.split("/").pop().split(".")[0]);

		}   // transition callback (scope set to element that was shown):  
                
        });*/
}

