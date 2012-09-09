///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Begin of include track.js file
//

// Pixel Object constructor
// baseUrl is required.
// moreParams need "?" or "&" prepended, depending on baseUrl
function Pixel(baseUrl, moreParams) {
    this.baseUrl = baseUrl;
    this.moreParams = moreParams;

    this.RenderPixel = function() {
        $('body').append('<img src="' + this.baseUrl + ((this.moreParams !== undefined) ? this.moreParams : "") + '" height="1" width="1" /> ');
    }
}

// Dictionary object constructor and member functions to add and lookup Pixel objects keyed by AffiliateIDs
function Dictionary() {
    this.Add = function() {
        for (c=0; c < arguments.length; c+=2) {
            this[arguments[c]] = arguments[c+1];
        }
    }

    this.Get = function(key) {
        return(this[key]);
    }
}

function GetPixel(affiliateID) {
    return pixelDictionary.Get(affiliateID);
}
// End of include track.js file
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

