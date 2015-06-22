var eb = new vertx.EventBus("http://" + location.hostname + ":8000/eventbus");
eb.onopen = function() {
    console.log("Done!");
}

var startTS = undefined;

function testClick() {
    console.log('CLICKED');
    startTS = Date.now();
    eb.send('test', {
	"test" : "test"
    }, function(data) {
	console.log("Time: " + (Date.now() - startTS));
    });
    console.log('DONE');
}
