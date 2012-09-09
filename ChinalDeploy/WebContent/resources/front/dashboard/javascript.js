if (top.location != self.location) { top.location = self.location.href }

// For discussion and comments, see: http://remysharp.com/2009/01/07/html5-enabling-script/
(function () { if (!/*@cc_on!@*/0) return; var e = "abbr,article,aside,audio,bb,canvas,datagrid,datalist,details,dialog,eventsource,figure,footer,header,hgroup,mark,menu,meter,nav,output,progress,section,time,video".split(','); for (var i = 0; i < e.length; i++) { document.createElement(e[i]) } })()

window.onerror = function (errorMsg, url, lineNumber) {
    var args = '{"Message":" ' + errorMsg + ' \r\nSOURCE: ' + url + ' [line ' + lineNumber + ']"}';
    if (jQuery) {
        $.ajax({ url: '/jsError.aspx/LogError', type: "POST", data: args, contentType: 'application/json; charset=utf-8' });
    }
    // return false will let the default handler in the browser run. We need to decide if we want to do this.
    return false;
}

// ******************************
// LAUNCH WINDOW FUNCTIONS
// ******************************

// this is a precaution for inline logging leaking on to production. This way we can call console.log() without IE breaking.
if (!window.console || typeof window.console == "undefined") {
    window.console = {};
    window.console.log = function () { };
}

// launchRemote function launches a new window with specific attributes. launch function supports.
function launch(newURL, newName, newFeatures) {
    var remote = open(newURL, newName, newFeatures);
    if (remote.opener == null)
        remote.opener = window;
    return remote;
}

function launchRemote(pageName, uniqueName, winHeight, winWidth, isModalMode) {
    if (isModalMode && window.showModalDialog)//checks for showModalDialog support in browser
    {
        window.showModalDialog(pageName, this, 'dialogWidth:' + winWidth + 'px; dialogHeight:' + winHeight + 'px; status:no; center:yes')
    }
    else {
        myRemote = launch(pageName, uniqueName, "height=" + winHeight + ",width=" + winWidth + ",screenX=100,left=100,screenY=100,top=100,channelmode=0,dependent=0,directories=0,fullscreen=0,location=0,menubar=0,resizable=1,scrollbars=1,status=0,toolbar=0");
        myRemote.focus();
    }
}

var usStates = { AL: 'Alabama', AK: 'Alaska', AZ: 'Arizona', AR: 'Arkansas', CA: 'California', CO: 'Colorado', CT: 'Connecticut', DE: 'Delaware', DC: 'District of Columbia', FL: 'Florida', GA: 'Georgia', HI: 'Hawaii', ID: 'Idaho', IL: 'Illinois', IN: 'Indiana', IA: 'Iowa', KS: 'Kansas', KY: 'Kentucky', LA: 'Louisiana', ME: 'Maine', MD: 'Maryland', MA: 'Massachusetts', MI: 'Michigan', MN: 'Minnesota', MO: 'Missouri', MT: 'Montana', NE: 'Nebraska', NV: 'Nevada', NH: 'New Hampshire', NJ: 'New Jersey', NM: 'New Mexico', NY: 'New York', NC: 'North Carolina', ND: 'North Dakota', OH: 'Ohio', OK: 'Oklahoma', OR: 'Oregon', PA: 'Pennsylvania', RI: 'Rhode Island', SC: 'South Carolina', SD: 'South Dakota', TN: 'Tennessee', TX: 'Texas', UT: 'Utah', VT: 'Vermont', VA: 'Virginia', WA: 'Washington', WV: 'West Virginia', WI: 'Wisconsin', WY: 'Wyoming' };

// ******************************
// String display functions
// ******************************
function GetStateNameFromAbbreviation(abbr) {
    var rv = abbr;
    if ('AL' == abbr) rv = 'Alabama'; else if ('AK' == abbr) rv = 'Alaska'; else if ('AZ' == abbr) rv = 'Arizona'; else if ('AR' == abbr) rv = 'Arkansas';
    else if ('CA' == abbr) rv = 'California'; else if ('CO' == abbr) rv = 'Colorado'; else if ('CT' == abbr) rv = 'Connecticut';
    else if ('DE' == abbr) rv = 'Deleware'; else if ('DC' == abbr) rv = 'District of Columbia';
    else if ('FL' == abbr) rv = 'Florida';
    else if ('GA' == abbr) rv = 'Georgia';
    else if ('HI' == abbr) rv = 'Hawaii';
    else if ('ID' == abbr) rv = 'Idaho'; else if ('IL' == abbr) rv = 'Illinois'; else if ('IN' == abbr) rv = 'Indiana'; else if ('IA' == abbr) rv = 'Iowa';
    else if ('KS' == abbr) rv = 'Kansas'; else if ('KY' == abbr) rv = 'Kentucky';
    else if ('LA' == abbr) rv = 'Louisiana';
    else if ('ME' == abbr) rv = 'Maine'; else if ('MD' == abbr) rv = 'Maryland'; else if ('MA' == abbr) rv = 'Massachusetts'; else if ('MI' == abbr) rv = 'Michigan'; else if ('MN' == abbr) rv = 'Minnesota'; else if ('MS' == abbr) rv = 'Mississippi'; else if ('MO' == abbr) rv = 'Missouri'; else if ('MT' == abbr) rv = 'Montana';
    else if ('NE' == abbr) rv = 'Nebraska'; else if ('NV' == abbr) rv = 'Nevada'; else if ('NH' == abbr) rv = 'New Hampshire'; else if ('NJ' == abbr) rv = 'New Jersey'; else if ('NM' == abbr) rv = 'New Mexico'; else if ('NY' == abbr) rv = 'New York'; else if ('NC' == abbr) rv = 'North Carolina'; else if ('ND' == abbr) rv = 'North Dakota';
    else if ('OH' == abbr) rv = 'Ohio'; else if ('OK' == abbr) rv = 'Oklahoma'; else if ('OR' == abbr) rv = 'Oregon';
    else if ('PA' == abbr) rv = 'Pennsylvania';
    else if ('RI' == abbr) rv = 'Rhode Island';
    else if ('SC' == abbr) rv = 'South Carolina'; else if ('SD' == abbr) rv = 'South Dakota';
    else if ('TN' == abbr) rv = 'Tennessee'; else if ('TX' == abbr) rv = 'Texas';
    else if ('UT' == abbr) rv = 'Utah';
    else if ('VT' == abbr) rv = 'Vermont'; else if ('VA' == abbr) rv = 'Virginia';
    else if ('WA' == abbr) rv = 'Washington'; else if ('WV' == abbr) rv = 'West Virginia'; else if ('WI' == abbr) rv = 'Wisconsin'; else if ('WY' == abbr) rv = 'Wyoming';

    return rv;
}

function toDollarAmountString(num, addDollarSign) {
    var dollarSignStr = "";
    if (addDollarSign) dollarSignStr = "$";
    if (!num || /^\s*$/.test(num)) {
        return "";
    } else if (!isNaN(num)) {
        var n = new Number(num);
        return dollarSignStr + addCommas(n.toFixed(2).toString());
    }
    else {
        return null;
    }
}

function addCommas(strNum) {
    strNum += '';

    x = strNum.split('.');
    x1 = x[0];
    x2 = x.length > 1 ? "." + x[1] : '';

    var rgx = /(\d+)(\d{3})/;
    while (rgx.test(x1)) {
        x1 = x1.replace(rgx, '$1' + ',' + '$2');
    }

    return x1 + x2;
}

function currencyToDecimal(strNum) {
    return strNum.replace(/[$,]/ig, "");
}


// ******************************
// CONFIRM FUNCTIONS
// ******************************


// ConfirmAction function adds confirmation box to any deletions
function ConfirmAction(url, text) {
    if (confirm('Are you sure you want to ' + text + '?')) {
        document.location = url;
    }
}

// ConfirmActionButton function adds confirmation box to any button deletions
function ConfirmActionButton(url, text) {
    if (confirm('Are you sure you want to ' + text + '?')) {
        document.location = url;
    }
}

// ******************************
// FORM FUNCTIONS
// ******************************

function disableEnterKey(e) {
    var key;
    if (window.event) key = window.event.keyCode; //IE
    else key = e.which; //firefox     
    return (key != 13);
}

/* Set all checkboxes in a form that match a prefix */
function setAllCheckboxes(vChecked, prefix, includeDisabled) {
    var elm = document.forms[0].elements;
    for (i = 0; i < elm.length; i++) {
        if (elm[i].type == "checkbox") {
            if (elm[i].id != null && (prefix == null || elm[i].id.indexOf(prefix) == 0)) {
                if (includeDisabled == null || includeDisabled || (!includeDisabled && !elm[i].disabled))
                    elm[i].checked = vChecked;
            }
        }
    }
}

// selectLink is used on pulldown menus to automatically open a URL based on the user's selection

function selectLink(sURL) {
    if (sURL != "") {
        // first param is the URL, second param is the frame name
        open(sURL, "_self");

        // parent.archive.location = sURL
    }
}


// tabNext is used to automatically move the cursor to successive form fields

var text_field_object = null;
var text_field_length = 0;
function tabNext(obj, event, len, next_field) {
    if (event == "down") {
        text_field_object = obj;
        text_field_length = obj.value.length;
    }
    else if (event == "up") {
        // check that the keypress didn't move fields, and that a character was added
        if (text_field_object == obj && text_field_length != obj.value.length) {
            if (obj.value.length == len) {
                next_field.focus();
                next_field.select();
            }
        }
    }
}

function setFocus(id) {
    //  Firefox workaround for https://bugzilla.mozilla.org/show_bug.cgi?id=53579
    if (isFirefox()) {
        window.setTimeout("document.getElementById(\"" + id + "\").focus();", 100)
    }
    else {
        document.getElementById(id).focus();
    }
}

// ******************************
// BROWSER DETECTION FUNCTIONS
// ******************************

function isFirefox() {
    return navigator.userAgent.indexOf('Firefox') > 0;
}

function isFirefox2() {
    return isFirefox() && navigator.appVersion.charAt(0) == "5";
}

function isInternetExplorer() {
    return navigator.userAgent.indexOf('MSIE') > 0;
}


// ******************************
// MATH FUNCTIONS
// ******************************

function roundToDecimalPlace(num, decimalPlaces) {
    if (!isNaN(num)) {
        var n = new Number(num);
        return n.toFixed(decimalPlaces);
    }
    else {
        return null;
    }
}

// ******************************
// VISIBILITY FUNCTIONS
// ******************************

// Shows or hides any element specified by the the id param. show == true => show, show == false => hide
function showHideContent(id, show) {
    var elem = document.getElementById(id);
    if (elem) {
        if (show) {
            elem.style.display = '';
            elem.style.visibility = 'visible';
        }
        else {
            elem.style.display = 'none';
            elem.style.visibility = 'hidden';
        }
    }
}

function isVisible(id) {
    var isVisible2 = true;
    var elem = document.getElementById(id);
    if (elem) {
        isVisible2 = !(elem.style.display == 'none' || elem.style.visibility == 'hidden');
    }
    return isVisible2;
}

function toggleVisibility(id) {
    showHideContent(id, !isVisible(id));
}

/* -- Used to toggle sections throughout help section. Expects content in this format: -- */
/* -- <div class="collapsible"><h4 class="collapsed" onClick="toggleBlock(this,'divSection')">Who can borrow money on Prosper?</h4>
<div id="divSection" style="display: none;" class="togglePanel"><p>Content.</p></div></div>   -- */
function toggleAnchor() {
    var hash = window.location.hash;
    hash = hash.substring(1);
    toggleBlock('div' + hash);
}
function toggleBlock(targetId) {
    var div = document.getElementById(targetId);
    if (div) {
        var subDivs = div.getElementsByTagName('div');
        for (var i = 0; i < subDivs.length; i++) {
            if (subDivs[i].className.match(/togglePanel/)) {
                var togglePanel = subDivs[i];
            }
        }
        var titlePanel = div.getElementsByTagName('h4')[0];

        if (togglePanel) {
            if (togglePanel.style.display != 'block') {
                togglePanel.style.display = 'block';
                titlePanel.className = 'expanded';
            } else {
                togglePanel.style.display = 'none';
                titlePanel.className = 'collapsed';
            }
        }
    }
}
function toggleAll(parentDiv, targetDisplay) {
    var divs = parentDiv.getElementsByTagName('div');

    for (var i = 0; i < divs.length; i++) {
        if (divs[i].className == 'collapsible') {
            var title = divs[i].getElementsByTagName('h4')[0];

            var subDivs = divs[i].getElementsByTagName('div');
            for (var j = 0; j < subDivs.length; j++) {
                if (subDivs[j].className.match(/togglePanel/)) {
                    var togglePanel = subDivs[j];
                }
            }

            if (togglePanel.style.display != targetDisplay) {
                toggleBlock(divs[i].id);
            }
        }
    }
}

/* Use this to find the first instance of an element that partially matches the id substring. This is useful
when dotNet adds each page and control prefixing the name of the element you are attempting to access.
Limitations: this will not be useful on pages where more than one element matches the id sub string
*/
function findFullID(idSubstring) {
    var elements = document.forms[0].elements;
    var fullId;
    var currentId;
    var currentIdString = '';

    if (elements) {
        for (i = 0; i < elements.length; i++) {
            currentId = elements[i].id;
            if (currentId) {
                currentIdString = currentId.toString();
                if (currentIdString.indexOf(idSubstring) > -1) {
                    fullId = elements[i].id;
                    break;
                }
            }
        }
    }

    return fullId;
}

function genUrl(requests, fileName) {
    var url = fileName;
    var i = 0;
    for (requestId in requests) {
        if (i == 0)
            url = url + "?" + requestId + "=" + requests[requestId];
        else
            url = url + "&" + requestId + "=" + requests[requestId];
        i++;
    }
    return url;
}


///Adds option to option list
function addOption(selectObject, optionText, optionValue) {
    var optionObject = new Option(optionText, optionValue);
    var optionRank = selectObject.options.length;
    //check for its existence first
    if (!isInList(selectObject, optionText, optionValue)) {
        selectObject.options[optionRank] = optionObject;
    }
}

//selects all options in the given list (IMPORTANT so that values POSTBACK!)
function selectAllOptions(selectObject) {
    var i = 0;
    for (i = 0; i < selectObject.options.length; i++) {
        selectObject.options[i].selected = true;
    }
}

///Checks if option is already in given list
function isInList(selectObject, optionText, optionValue) {
    var blnIsInList = false;
    for (i = 0; i < selectObject.options.length; i++) {
        if (optionValue == selectObject.options[i].value) {
            blnIsInList = true;
            break
        }
    }
    return blnIsInList;
}

//removes selected options from the given list
function removeOptions(selectObject) {
    //check if there's an item selected
    if (selectObject.selectedIndex != -1) {
        if (selectObject.options.length != 0) {
            var i = 0;
            //loop through all options
            for (i = selectObject.options.length - 1; i >= 0; i--) {
                if (selectObject.options[i].selected == true) {
                    selectObject.options[i] = null;
                }
            }

        }
    }
    else {
        alert("Select an item first (if any) before clicking Remove.")
    }
}

function removeOption(selectObject, optionIndex) {
    if (selectObject != null) {
        if (selectObject.options.length != 0) {
            selectObject.options.remove(optionIndex);
        }
    }
}

function removeOptionByValue(selectObject, val) {
    if (selectObject != null) {
        if (selectObject.options.length != 0) {
            var i = 0;
            //loop through all options
            for (i = selectObject.options.length - 1; i >= 0; i--) {
                if (selectObject.options[i] != null) {
                    if (selectObject.options[i].value == val) {
                        selectObject.options[i] = null;
                    }
                }
            }
        }
    }
}


// ******************************
// PAGING FUNCTIONS
// ******************************

/// <summary>
/// Navigates to the given url (url should end with a &page_index= type of variable)
/// after clicking on "Go" button in paging area. The entered pageNum is 1 (one) based.
/// page index is 0 (zero) based
/// Checks if the number given is less than or equal to max pagecount.
/// </summary>
function gotoPageNumber(url, pageNum, pageCount) {
    if (!isNaN(pageNum) && pageNum > 0 && pageNum <= pageCount) {
        window.location.href = url + (pageNum - 1);
    }
}

/// <summary>
/// Similar to gotoPageNumber, but submits the page uses .Net __doPostBack (POST not a GET)
/// after clicking on "Go" button in paging area. The entered pageNum is 1 (one) based.
/// but that is how ASP.Net 2.0 likes it.
/// Checks if the number given is less than or equal to max pagecount.
/// </summary>
function postBackPageNumber(controlID, pageNum, pageCount) {
    if (!isNaN(pageNum) && pageNum > 0 && pageNum <= pageCount) {
        __doPostBack(controlID, 'Page$' + (pageNum)); return false;
    }
}

// ******************************
// SESSION TIMEOUT WARNING FUNCTIONS
// ******************************
function displaySessionTimeoutAlert() {
    if (frames['sessionKeepAliveFrame'] != null && frames['sessionKeepAliveFrame'] != 'undefined') {
        alert('Your Prosper session is about to expire. As a security precaution, sessions expire after ' + _sessionTimeOutMinutes + ' minutes of inactivity.\nClick OK to continue your session.');
        frames['sessionKeepAliveFrame'].location.href = '/session_keep_alive.aspx';
        // defaultTimeOutMilliseconds is set programmatically  2 minutes less than session timeout
        startSessionTimeoutTimer(_sessionTimeOutWarningMilliseconds);
    }
}
var _sessionTimeOutWarningMilliseconds = 1080000; var _sessionTimeOutMinutes = 20;
var tout;
function startSessionTimeoutTimer(timeOutMilliseconds, sessionTimeOutMinutes) {
    tout = window.setTimeout('displaySessionTimeoutAlert()', timeOutMilliseconds);
    _sessionTimeOutWarningMilliseconds = timeOutMilliseconds;
    _sessionTimeOutMinutes = sessionTimeOutMinutes;
}

// ******************************
// MULTI-LINE TEXT BOX / TEXTAREA LIMITER
// ******************************
//see SetMultiLineTextBoxMaxLength
// Different browsers add different characters when pressing enter key
//"\r" (ex: on mac) one char, 
//"\n" (ex: on firefox) one char
//"\r\n" (ex: on IE) two char. 
//Regardless, C# translates all line breaks to \r\n.

function checkLength(field, len) {
    var val = field.value;
    var lineBreakIsRN = false; // IE windows
    var lineBreakIsROnly = false; //IE Mac
    var lineBreakIsNOnly = false; //FireFox all

    if (val.indexOf('\r\n') != -1) {
        //do nothing. this is IE on windows. Puts both characters for a newline, just what C# does. No need to alter.
        lineBreakIsRN = true;
    }
    else if (val.indexOf('\r') != -1) {
        //this is IE on a Mac. Need to add the line feed
        val = val.replace(/\r/g, "\r\n");
        lineBreakIsROnly = true;
    }
    else if (val.indexOf('\n') != -1) {
        //this is Firefox on any platform. Need to add carriage return  
        val = val.replace(/\n/g, "\r\n");
        lineBreakIsNOnly = true;
    }

    if (val.length > len) {
        field.value = val.substring(0, len); // too long...trim it!

        if (lineBreakIsRN) { ; }
        else if (lineBreakIsROnly)
        { field.value = field.value.replace(/\n/g, ""); } //remove all \n's put it back the way it was
        else if (lineBreakIsNOnly)
        { field.value = field.value.replace(/\r/g, ""); } //remove all \r's put it back the way it was
    }
}

// Extracts a number from a text input as a float, stripping %, comma's and dollar signs
// If after these characters are stripped and number is still unparsable then this returns
// NaN. Null input is also returned as NaN
function extractNumber(inputVal) {
    var result = NaN;
    if (inputVal != null) {
        var cleanedInput = inputVal.replace(',', '');
        cleanedInput = cleanedInput.replace('$', '');
        cleanedInput = cleanedInput.replace('%', '');
        result = parseFloat(cleanedInput);
    }
    return result;
}


// ******************************
// RADIO BUTTON HELPER FUNCTIONS
// ******************************
function getRadioButtonSelectedIndex(buttonGroupName) {
    var buttonGroup = document.getElementsByName(buttonGroupName);
    // returns the array number of the selected radio button or -1 if no button is selected
    if (buttonGroup[0]) { // if the button group is an array (one button is not an array)
        for (var i = 0; i < buttonGroup.length; i++) {
            if (buttonGroup[i].checked) {
                return i
            }
        }
    } else {
        if (buttonGroup.checked) { return 0; } // if the one button is checked, return zero
    }
    // if we get to this point, no radio button is selected
    return -1;
} // Ends the "getRadioButtonSelectedIndex" function

function getRadioButtonSelectedValue(buttonGroupName) {
    var buttonGroup = document.getElementsByName(buttonGroupName);
    // returns the value of the selected radio button or "" if no button is selected
    var i = getRadioButtonSelectedIndex(buttonGroupName);
    if (i == -1) {
        return "";
    } else {
        if (buttonGroup[i]) { // Make sure the button group is an array (not just one button)
            return buttonGroup[i].value;
        } else { // The button group is just the one button, and it is checked
            return buttonGroup.value;
        }
    }
} // Ends the "getRadioButtonSelectedValue" function

// ******************************
// Creates a cookie
// ******************************
function createCookie(name, value, days) {
    if (days) {
        var d = new Date();
        d.setTime(d.getTime() + (days * 24 * 60 * 60 * 1000));
        var expires = "; expires=" + d.toGMTString();
    }
    else var expires = "";
    var domain = " ;domain =" + getCookie('prosperDomain');
    document.cookie = name + "=" + value + expires + domain + "; path=/";

}
function deleteCookie(cookie_name) {
    var cookie_date = new Date();  // current date & time
    cookie_date.setTime(cookie_date.getTime() - 1);
    document.cookie = cookie_name += "=; expires=" + cookie_date.toGMTString() + "; path=/";
}

// this fixes an issue with the old method, ambiguous values
// with this test document.cookie.indexOf( name + "=" );
function getCookie(check_name) {
    // first we'll split this cookie up into name/value pairs
    // note: document.cookie only returns name=value, not the other components
    var a_all_cookies = document.cookie.split(';');
    var a_temp_cookie = '';
    var cookie_name = '';
    var cookie_value = '';
    var b_cookie_found = false; // set boolean t/f default f

    for (i = 0; i < a_all_cookies.length; i++) {
        // now we'll split apart each name=value pair
        a_temp_cookie = a_all_cookies[i].split('=');


        // and trim left/right whitespace while we're at it
        cookie_name = a_temp_cookie[0].replace(/^\s+|\s+$/g, '');

        // if the extracted name matches passed check_name
        if (cookie_name == check_name) {
            b_cookie_found = true;
            // we need to handle case where cookie has no value but exists (no = sign, that is):
            if (a_temp_cookie.length > 1) {
                cookie_value = unescape(a_temp_cookie[1].replace(/^\s+|\s+$/g, ''));
            }
            // note that in cases where cookie is initialized but no value, null is returned
            return cookie_value;
            break;
        }
        a_temp_cookie = null;
        cookie_name = '';
    }
    if (!b_cookie_found) {
        return null;
    }
}


function getCookieDomian() {
    // first we'll split this cookie up into name/value pairs
    // note: document.cookie only returns name=value, not the other components
    var check_name = 'prosperRole';
    var a_all_cookies = document.cookie.split(';');
    var a_temp_cookie = '';
    var cookie_name = '';
    var cookie_value = '';
    var b_cookie_found = false; // set boolean t/f default f

    for (i = 0; i < a_all_cookies.length; i++) {
        // now we'll split apart each name=value pair
        a_temp_cookie = a_all_cookies[i].split('=');


        // and trim left/right whitespace while we're at it
        cookie_name = a_temp_cookie[0].replace(/^\s+|\s+$/g, '');

        // if the extracted name matches passed check_name
        if (cookie_name == check_name) {
            b_cookie_found = true;
        }

        if ((cookie_name == 'domain') & (b_cookie_found == true)) {

            // we need to handle case where cookie has no value but exists (no = sign, that is):
            if (a_temp_cookie.length > 1) {
                cookie_value = unescape(a_temp_cookie[1].replace(/^\s+|\s+$/g, ''));
            }
            // note that in cases where cookie is initialized but no value, null is returned
            return cookie_value;
            break;
        }
        a_temp_cookie = null;
        cookie_name = '';
    }
    if (!b_cookie_found) {
        return null;
    }
}



// ******************************
// VALIDATION
// ******************************


// ***********************************************************
// Check that a valid path was submitted in a file input
// ***********************************************************
function isValidUploadFilePath(fileName) {
    var filePathRegex = /^([a-zA-Z]{0,1})((:\\|\\|\/|\\\\|\/\/){0,1})(.*)\.([0-9a-zA-Z]{1,4})$/;
    /* optional drive letter, os independent root path symbol(s), any number of path symbols, a dot, and then a file extension 1 to 4 chars */

    var isValid = false;
    if (fileName != null && fileName != '') {
        isValid = fileName.match(filePathRegex);
    }

    return isValid;
}

// ****************************************************************************************
// Used for validating if the user has submitted a valid image file in a file upload input
// ****************************************************************************************
function isValidImageFile(fileName) {
    //alert(fileName);
    var isValid = false;
    var imageFileRegex = /^(.*)(.bmp$|.\.jpg$|.\.jpeg$|.\.gif$|.\.png$|.\.tif$|.\.tiff$)/;

    if (fileName != null) {
        var lowerFileName = fileName.toLowerCase();
        isValid = isValidUploadFilePath(lowerFileName) && lowerFileName.match(imageFileRegex);
    }

    return isValid;
}

//variable to hold table rows with validators
var tableRows = new Array();

function valHighlightAllInvalid_ClientValidate(sender, args) {
    // Do nothing if client validation is not active
    if (typeof (Page_Validators) == "undefined") return;

    ClearAllRowFormatting();

    //clear the array
    tableRows.length = 0;

    highlightValidatorContainers(Page_Validators)
}

function highlightValidatorContainers(validators, forceHighlight) {
    // Do nothing if invalid validators array not defined
    if (typeof (validators) == "undefined") return;

    for (i = 0; i < validators.length; i++) {
        var val = validators[i];
        var tr = FindParentElementByTagName(val, 'tr');
        if (tr && tr != 'undefined') {
            if (!tableRows.Contains(tr)) {
                tableRows.push(tr);
            }
            if (!val.isvalid || forceHighlight) {
                highlightInvalid(tr, val);
            }
        }
    }
}

function highlightInvalid(container, val) {
    container.className = 'error_row';

    //addToolTipToControlToValidate(val)
    var controlId = val.controltovalidate;
    if (typeof (controlId) != "undefined") {
        var control = document.getElementById(controlId);
        if (control) {
            control.title = val.errormessage;
        }
        val.title = val.errormessage;
    }
    else {
        //alert("no controltovalidate: " + controlId); 
        //optionally add tooltip to whole row (double errors will be overwritten by last error)
        container.title = val.errormessage != null && val.errormessage.length > 0 ? val.errormessage : 'please correct this field';
    }

}

//clears all formatting for all rows in the global tableRows variable
function ClearAllRowFormatting() {
    for (i = 0; i < tableRows.length; i++) {
        var tr = tableRows[i];
        tr.className = '';
        //tr.setAttribute("className", ""); 
        //alert(tr.className);
        //tr.style.backgroundColor='white';
        tr.title = '';
    }
}

//Finds an html element by tag name. Useful for finding the containing tr of a validator
function FindParentElementByTagName(element, tagname) {
    tagname = tagname.toLowerCase();
    var parentElement;
    while ((element = element.parentNode) && !parentElement) {
        if (element && element.tagName && element.tagName.toLowerCase() == tagname) {
            parentElement = element;
        }
    }
    //if (parentElement) alert(parentElement.id);
    return parentElement;
}

//This prototype extends the DOM Array object adding support for "Contains" (there's no native Contains or InArray function)
Array.prototype.Contains = function (value) {
    var i;
    for (i = 0; i < this.length; i++) {
        if (this[i] === value) {
            return true;
        }
    }
    return false;
};

// ******************************
// AJAX functions
// ******************************

//  Reference: http://www.w3.org/TR/XMLHttpRequest/
function getXMLHttpRequest() {
    var xmlHttp = null;
    if (window.XMLHttpRequest) {
        try {
            xmlHttp = new XMLHttpRequest(); //IE7, Firefox, Safari
        } catch (e) { }
    } else if (window.ActiveXObject) {
        try {
            xmlHttp = new ActiveXObject("Msxml2.XMLHTTP"); //IE6
        } catch (e) {
            try {
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP"); //IE5.X
            } catch (e) { }
        }
    }
    return xmlHttp;
}

// Tooltips, based on qTip //
var tipTag = "abbr,acronym,span"; //Tags to check for //
var tooltipX = -5; //This is qTip's X offset//
var tooltipY = 3; //This is qTip's Y offset//

var tooltip = {
    name: "tooltip",
    offsetX: tooltipX,
    offsetY: tooltipY,
    tip: null
}
tooltip.init = function () {
    var tipNameSpaceURI = "http://www.w3.org/1999/xhtml";
    if (!tipContainerID) { var tipContainerID = "tooltip"; }
    var tipContainer = document.getElementById(tipContainerID);

    if (!tipContainer) {
        tipContainer = document.createElementNS ? document.createElementNS(tipNameSpaceURI, "div") : document.createElement("div");
        tipContainer.setAttribute("id", tipContainerID);
        document.getElementsByTagName("body").item(0).appendChild(tipContainer);
    }

    if (!document.getElementById) return;
    this.tip = document.getElementById(this.name);
    // if (this.tip) document.onmousemove = function (evt) {tooltip.move (evt)};

    var a, sTitle, elements;

    var elementList = tipTag.split(",");
    for (var j = 0; j < elementList.length; j++) {
        elements = document.getElementsByTagName(elementList[j]);
        if (elements) {
            for (var i = 0; i < elements.length; i++) {
                a = elements[i];
                sTitle = a.getAttribute("title");
                if (sTitle) {
                    a.setAttribute("tiptitle", sTitle);
                    a.removeAttribute("title");
                    a.removeAttribute("alt");
                    a.className = "hasTooltip";
                    a.onmouseover = function (evt) { tooltip.show(evt, this.getAttribute('tiptitle')) };
                    a.onmouseout = function () { tooltip.hide() };
                }
            }
        }
    }

    if (jQuery) {
        $.each($('.divWithTooltip'), function (i, val) {
            if ($(this).attr('title')) {
                $(this).attr('tiptitle', $(this).attr('title'));
                $(this).attr('title', '');

                if ((navigator.userAgent.match(/iPhone/i)) || (navigator.userAgent.match(/iPod/i)) || (navigator.userAgent.match(/iPad/i))) {
                    $(this).bind('touchstart', function (evt) {
                        tooltip.show(evt, this.getAttribute('tiptitle'));
                        return false;
                    });
                } else {
                    $(this).hover(function (evt) { tooltip.show(evt, this.getAttribute('tiptitle')) },
                        function () { tooltip.hide() }
                    );
                }
            }
        });
    }
}

tooltip.show = function (evt, text) {
    if (!this.tip) return;

    var x = 0, y = 0;
    if (document.all) {//IE
        x = (document.documentElement && document.documentElement.scrollLeft) ? document.documentElement.scrollLeft : document.body.scrollLeft;
        y = (document.documentElement && document.documentElement.scrollTop) ? document.documentElement.scrollTop : document.body.scrollTop;
        x += window.event.clientX;
        y += window.event.clientY;

    } else {//Good Browsers
        x = evt.pageX;
        y = evt.pageY;
        if ((navigator.userAgent.match(/iPhone/i)) || (navigator.userAgent.match(/iPod/i)) || (navigator.userAgent.match(/iPad/i))) {
            x = evt.originalEvent.touches[0].pageX;
            y = evt.originalEvent.touches[0].pageY;
        }
    }
    this.tip.style.left = (x + this.offsetX) + "px";
    this.tip.style.top = (y + this.offsetY) + "px";

    this.tip.innerHTML = "<div class='tooltipBody'>" + text + "</div>";
    this.tip.style.display = "block";
}
tooltip.hide = function () {
    if (!this.tip) return;
    this.tip.innerHTML = "";
    this.tip.style.display = "none";
}

/* Help style mouseover dialogs. Requires jquery. */
function displayHelptip(e) {
    if (e.type == "mouseover") {
        $(this).find(".popup").show();
    } else {
        $(this).find(".popup").hide();
    }
}
function setHelptips() {
    $(".helpOver").bind("mouseover", displayHelptip);
    $(".helpOver").bind("mouseout", displayHelptip);
}

// Check for a Google Analytics tracker before using it //
function gaLoaded(path) {
    if (typeof (pageTracker) != "undefined") {
        pageTracker._trackPageview(path);
    }
}


/* Set user source pixel */
function setSource(qs, ref) {
    if (qs != "" && qs.search(/refmc/i) != -1) {
        // Refac, refmc passed through querystring.
        var pass = "?";
        qs = qs.slice(1);
        pairs = qs.split('&');
        for (var i = 0; i < pairs.length; i++) {
            values = pairs[i].split('=');
            if (values[0] == "refac" || values[0] == "refmc" || values[0] == "refd" || values[0] == "refl") {
                if (i > 0) { pass += "&"; }
                pass += pairs[i];
            }
        }

        callPixel(pass);
    } else {
        if (ref == "") {
            // Direct request, only record if not a returning user.
            if (!checkReturningUser()) {
                var pass = "?refac=CANMB&refmc=AOUIDTO";
                callPixel(pass);
            }
        } else if ((ref.search(window.location.hostname) == -1)) {
            // Has referrer, and it's not internal to site.
            var engine = "";

            if (ref.search(/google/i) != -1) {
                engine = "google";
            } else if (ref.search(/yahoo/i) != -1) {
                engine = "yahoo";
            } else if (ref.search(/bing/i) != -1) {
                engine = "bing";
            } else if (ref.search(/aol/i) != -1) {
                engine = "aol";
            }

            if (engine != "") {
                // Search engine referral
                searchReferrals(ref, engine);
            } else {
                // Website referral
                var pass = "?refac=RAJVU&refmc=WSJLHZP&refd=ref:" + ref;
                callPixel(pass);
            }
        }
    }
}

function checkReturningUser() {
    var returningUser = false;
    cookie = document.cookie;
    if (cookie.search(/login/i) != -1) {
        returningUser = true;
    } else if (cookie.search(/affref/i) != -1) {
        returningUser = true;
    }

    return returningUser;
}

/* Process referral from search engine */
function searchReferrals(ref, engine) {
    var query = "";
    var refmc = "";
    var parts = ref.split("?");
    var qs = parts[1];

    if (qs) {
        pairs = qs.split('&');
        for (var i = 0; i < pairs.length; i++) {
            values = pairs[i].split('=');

            if (engine == "google") {
                if (values[0] == "q") {
                    query = values[1];
                }
            } else if (engine == "yahoo") {
                if (values[0] == "p") {
                    query = values[1];
                }
            } else if (engine == "bing") {
                if (values[0] == "q") {
                    query = values[1];
                }
            } else if (engine == "aol") {
                if (values[0] == "query" || values[0] == "q") {
                    query = values[1];
                }
            }
        }

        refac = 'ARVSD';

        if (query.search(/prosper/i) != -1) {
            refmc = "DWWZOMNI";
            refac = 'OBMWC';
        } else if (query.search(/peer|p2p|person+to|people/i) != -1) {
            refmc = "ZTZXWLX ";
            refac = 'OBMWC';
        } else if (query.search(/social/i) != -1) {
            refmc = "HANUBHH";
        } else if (query.search(/online.*invest|invest.*online/i) != -1) {
            refmc = "DQYXYPV";
        } else if (query.search(/opportunities|opportunity/i) != -1) {
            refmc = "AROANRU";
        } else if (query.search(/strategies|strategy/i) != -1) {
            refmc = "BIWGNWW";
        } else if (query.search(/alternative/i) != -1) {
            refmc = "MLWAOMF";
        } else if (query.search(/short term/i) != -1) {
            refmc = "NMPNLRO";
        } else if (query.search(/invest/i) != -1) {
            refmc = "QNFZAEX";
        } else if (query.search(/personal/i) != -1) {
            refmc = "TQPZMWO";
        } else if (query.search(/borrow/i) != -1) {
            refmc = "PPRWJZA";
        } else if (query.search(/online/i) != -1) {
            refmc = "VVVNDMP";
        } else if (query.search(/motorcycle/i) != -1) {
            refmc = "IAGCLUT";
        } else if (query.search(/military/i) != -1) {
            refmc = "KMMECNE";
        } else if (query.search(/consolidation/i) != -1) {
            refmc = "LNHXXHI";
        } else if (query.search(/business/i) != -1) {
            refmc = "VQXPAGU";
        } else if (query.search(/home.*improvement/i) != -1) {
            refmc = "IATAELV";
        } else if (query.search(/student/i) != -1) {
            refmc = "XRYTLWI";
        } else if (query.search(/ring/i) != -1) {
            refmc = "SZLBRXI";
        } else if (query.search(/wedding/i) != -1) {
            refmc = "MJDNRHW";
        } else if (query.search(/baby|adoption/i) != -1) {
            refmc = "CSWWOTX";
        } else if (query.search(/small/i) != -1) {
            refmc = "KBBWFNX";
        } else if (query.search(/unsecured/i) != -1) {
            refmc = "NSNLOXJ";
        } else if (query.search(/loan/i) != -1) {
            refmc = "PMXEZBU";
        } else {
            if (query.length > 1) {
                refmc = "IVVDBGZ";
            }
        }

        if (refmc != "") {
            var pass = "?refac=" + refac + "&refmc=" + refmc + "&refd=" + engine + ":" + query;
            callPixel(pass);
        }
    }
}

function callPixel(pass) {
    if (pass.length > 1) {
        var pixelURL = "/referrals/refer.aspx";
        var pixel = document.createElement("img");
        pixel.width = 1;
        pixel.height = 1;
        pixel.style.visibility = "hidden";
        pixel.src = pixelURL + pass;
    }
}


//* ----  UI display functions for new design  ---- *//
function secondaryNavOver() {
    $(this).parents("li").toggleClass("over");
}

function primaryNavOver() {
    var menu = $(this).parents(".menu");
    menu.addClass("over");
    menu.bind("mouseleave", primaryNavOut);
}

function primaryNavOut() {
    $(".header-primary .over").unbind('mouseleave');
    $(".header-primary .over").removeClass("over");
}

function hoverNavLast(event) {
    if (event.type == "mouseenter") {
        $(this).parents(".hover-menu").addClass("bottom-hover");
    } else {
        $(this).parents(".hover-menu").removeClass("bottom-hover");
    }
}

function prepNavs() {
    // Secondary navigation menu
    if (!$(".header-secondary li").hasClass("active")) {
        // If none of the secondary navs are active already, then prep hovers
        $(".header-secondary li a").hover(secondaryNavOver);
        preloadImg([
			'/Images/nav/nav-secondary-over-left.png',
			'/Images/nav/nav-secondary-over-right.png'
			]);
    }
}

function preloadImg(imageArray) {
    $(imageArray).each(function () {
        $("<img/>")[0].src = this;
    });
}

function setActiveSubmenu(className) {
    if (className != undefined) {
        if ($('li.' + className).length != 0) $('li.' + className).addClass('active');
    }
}

/*
function homeScroller() {
// slowly scroll the featured listings div up inside the scroller window.
var fl = $(".featured_listings");
var listings = $(".featured_listings .featured_listing");
	
fl.animate(
{ top: -listings.first().height()-8 },
6000,
'linear',
homeScrollEndless
);
}

function homeScrollEndless() {
// Move the first listing, then animate again.
var fl = $(".featured_listings");
var listings = $(".featured_listings .featured_listing");
listings.first().detach().appendTo(".featured_listings");
fl.css('top', 2);
	
homeScroller();
}
*/

var urlParams = {};

(function () {
    var e,
        a = /\+/g,  // Regex for replacing addition symbol with a space
        r = /([^&=]+)=?([^&]*)/g,
        d = function (s) { return decodeURIComponent(s.replace(a, " ")); },
        q = window.location.search.substring(1);

    while (e = r.exec(q))
        urlParams[d(e[1])] = d(e[2]);
})();

function getMultivariateTestVersion() {
    if (urlParams['v'] !== undefined) return urlParams['v'];
    return null;
}

function isMultivariateTestB() {
    var testVersion = getMultivariateTestVersion();
    if (testVersion == 'b') return true;
    return false;
}


//* -- Perform on window load  -- *//
window.onload = function () {
    tooltip.init(); // Tooltips
    setSource(document.location.search, document.referrer);
}



$(document).ready(function () {
    prepNavs();

    //$('input[title!=""]').hint();

    if ($('.divWithTooltip').length) {
        if ((navigator.userAgent.match(/iPhone/i)) || (navigator.userAgent.match(/iPod/i)) || (navigator.userAgent.match(/iPad/i))) {
            $(document).bind('touchstart', function () {
                if (tooltip != null && tooltip.tip.innerHTML !== "") {
                    tooltip.hide();
                }
            });
        }
    }

    $(".expandCollapseArrow").click(function () {
        $('.' + $(this).attr('id').substring('toggle-'.length)).toggle();
        ($(this).attr('src').indexOf('right') == -1) ? $(this).attr('src', '/images/icons/right.png') : $(this).attr('src', '/images/icons/asc.png');
    });

    $('.cta').each(function () {
        var fileorig = $(this).attr('src');
        var filehover = fileorig.substr(0, fileorig.length - 4) + "-over" + fileorig.substr(fileorig.length - 4);
        $(this).hover(
              function () {
                  $(this).attr('src', filehover);
              },
              function () {
                  $(this).attr('src', fileorig);
              }
            );
    });

    //only used on the home page.
    $("#quote_1").hide();
    $("#quote_" + (Math.floor(Math.random() * 3) + 1)).show();

    //Clear hint when homepage Get Rate Button is clicked
    $(".borrowerFunnelForm .button2012").click(function () {
        var moneyField = $(".borrowerFunnelForm .money");
        if (moneyField.val() === moneyField.get(0).title || moneyField.val() === '') {
            moneyField.val('').removeClass('blur');
        }
    });
});

/** 
 * Get Rate Progress Modal Module
 * 
 * The following constructs and renders the progress message for
 * when the user submits the registration form in the borrower funnel
 */
(function($){
    if (window.location.pathname == "/account/common/register.aspx") {
        var modalViewCss = {
            'modalWrapper' : {
                'background': 'rgb(0, 0, 0)',
                'background': 'rgba(0, 0, 0, 0.6)',
                'filter': 'progid:DXImageTransform.Microsoft.gradient(startColorstr=#99000000, endColorstr=#99000000)',
                '-ms-filter': '"progid:DXImageTransform.Microsoft.gradient(startColorstr=#99000000, endColorstr=#99000000)"',
                'position': 'fixed',
                'height': '100%',
                'width': '100%',
                'top': '0',
                'z-index': '100'
            },
            'modal' : {
                'background': '#555',
                'width': '600px',
                'height': '230px',
                'margin': '-115px 0 0 -300px',
                'top': '45%',
                'left': '50%',
                'position': 'fixed',
                'padding': '10px',
                'border-radius': '10px'
            },
            'modal.content' : {},
            'modal.content.hd' : {
                'background-image': 'url(data:image/gif;base64,R0lGODlhAQAyALMAAMnj89Xp9qPO6rzb8J3L6ZPG5rTX7qjR667U7eTx+dDm9MPf8drr9pjI5////47D5SH/C1hNUCBEYXRhWE1QPD94cGFja2V0IGJlZ2luPSLvu78iIGlkPSJXNU0wTXBDZWhpSHpyZVN6TlRjemtjOWQiPz4gPHg6eG1wbWV0YSB4bWxuczp4PSJhZG9iZTpuczptZXRhLyIgeDp4bXB0az0iQWRvYmUgWE1QIENvcmUgNS4zLWMwMTEgNjYuMTQ1NjYxLCAyMDEyLzAyLzA2LTE0OjU2OjI3ICAgICAgICAiPiA8cmRmOlJERiB4bWxuczpyZGY9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkvMDIvMjItcmRmLXN5bnRheC1ucyMiPiA8cmRmOkRlc2NyaXB0aW9uIHJkZjphYm91dD0iIiB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iIHhtbG5zOnhtcE1NPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvbW0vIiB4bWxuczpzdFJlZj0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL3NUeXBlL1Jlc291cmNlUmVmIyIgeG1wOkNyZWF0b3JUb29sPSJBZG9iZSBQaG90b3Nob3AgQ1M2IChXaW5kb3dzKSIgeG1wTU06SW5zdGFuY2VJRD0ieG1wLmlpZDoyNDcyNjFBMURCMzAxMUUxODBBOENGNjAwNDE4RUJCQSIgeG1wTU06RG9jdW1lbnRJRD0ieG1wLmRpZDoyNDcyNjFBMkRCMzAxMUUxODBBOENGNjAwNDE4RUJCQSI+IDx4bXBNTTpEZXJpdmVkRnJvbSBzdFJlZjppbnN0YW5jZUlEPSJ4bXAuaWlkOjI0NzI2MTlGREIzMDExRTE4MEE4Q0Y2MDA0MThFQkJBIiBzdFJlZjpkb2N1bWVudElEPSJ4bXAuZGlkOjI0NzI2MUEwREIzMDExRTE4MEE4Q0Y2MDA0MThFQkJBIi8+IDwvcmRmOkRlc2NyaXB0aW9uPiA8L3JkZjpSREY+IDwveDp4bXBtZXRhPiA8P3hwYWNrZXQgZW5kPSJyIj8+Af/+/fz7+vn49/b19PPy8fDv7u3s6+rp6Ofm5eTj4uHg397d3Nva2djX1tXU09LR0M/OzczLysnIx8bFxMPCwcC/vr28u7q5uLe2tbSzsrGwr66trKuqqainpqWko6KhoJ+enZybmpmYl5aVlJOSkZCPjo2Mi4qJiIeGhYSDgoGAf359fHt6eXh3dnV0c3JxcG9ubWxramloZ2ZlZGNiYWBfXl1cW1pZWFdWVVRTUlFQT05NTEtKSUhHRkVEQ0JBQD8+PTw7Ojk4NzY1NDMyMTAvLi0sKyopKCcmJSQjIiEgHx4dHBsaGRgXFhUUExIREA8ODQwLCgkIBwYFBAMCAQAAIfkEAAAAAAAsAAAAAAEAMgAABBfwyUmrnaU0QoQ4CGIYQ7kAqBIEjPMkEQA7)',
                'height': '50px',
                'border-radius': '9px 9px 0 0',
                'background-repeat': 'x-repeat'

            },
            'modal.content.bd.p' : {
                'font-size': '1.3em',
                'font-weight': 'bold',
                'margin-top':'43px',
                'margin-bottom': '10px'
            },
            'modal.content.bd' : { 'background':'#fff', 'width':'100%', 'height':'100%', 'border-radius':'8px', 'text-align': 'center' },
            'modal.content.ft' : {},
            'modalProgressSpinner' : {
                'position': 'absolute',
                'display' : 'block',
                'left': '50%',
                'margin-left': '-20px'
            }
        };

        var modalView = {
            /**
             * Modal dom tree
             * modalWrapper -> modal -> content ->[hd,bd,ft]
             */
            el: $('<div id="modalWrapper">')
                .append( $('<div id="modal">')
                    .append( $('<div class="content">')
                        .append( $('<div class="hd">')
                            .css(modalViewCss['modal.content.hd']))
                        .append( $('<div class="bd">')
                            // image rotating css keyframe object
                            .append($('<p style="">Your options are being calculated. This may take a moment.</p>')
                                .css(modalViewCss['modal.content.bd.p']))
                            .append($('<img src="/images/site/spinner-blue.gif" id="modalProgressSpinner" />')
                                .css(modalViewCss['modalProgressSpinner'])))
                        .append($('<div class="ft">'))
                        .css(modalViewCss['modal.content.bd']))
                    .css(modalViewCss['modal']))
                .css(modalViewCss['modalWrapper']),

            render: function () {
                this.el.appendTo('body');
            }
        }

        $(function(){
            $('div.continue input[type=image]').bind('click.loading', function () {
                modalView.render();
            });
        });

    }
})(jQuery);
// Get Rate Modal Module Ends


/**
 * Make input field placeholder functionality backwards
 * compatible
 * @param {jQuery} el 
 * @requires placeholder jQuery plugin
 */
(function($){
    $.fn.placeholderIsValue = function() {
        return this.val() === this.attr('placeholder');
    };

    $.fn.valueIsBlank = function() {
        return this.val() === '';
    };

    window.placeholder = function($el) {
        return $el.each(function() {
            $(this).placeholder();
            if ($(this).placeholderIsValue() || $(this).valueIsBlank()) {
                $(this).addClass('blur');
            }

            $(this).bind('focus.placeholder', function() {
                return $(this).removeClass('blur');
            });

            return $(this).bind('blur.placeholder', function() {
                if ($(this).placeholderIsValue() || $(this).valueIsBlank()) {
                    return $(this).addClass('blur');
                }
            });
        });
    };
    $(function(){
        window.placeholder($('[placeholder]'));
    });
})(jQuery);



